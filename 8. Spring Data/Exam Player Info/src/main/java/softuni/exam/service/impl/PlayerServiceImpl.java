package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PlayersSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.service.PictureService;
import softuni.exam.service.PlayerService;
import softuni.exam.service.TeamService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Arrays;

@Service
public class PlayerServiceImpl implements PlayerService {
    public static final String PLAYER_PATH = "src/main/resources/files/json/players.json";

    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final PlayerRepository playerRepository;
    private final ValidationUtil validationUtil;
    private final TeamService teamService;
    private final PictureService pictureService;

    @Autowired
    public PlayerServiceImpl(FileUtil fileUtil, Gson gson,
                             ModelMapper modelMapper, PlayerRepository playerRepository,
                             ValidationUtil validationUtil,
                             TeamService teamService, PictureService pictureService) {
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.playerRepository = playerRepository;
        this.validationUtil = validationUtil;
        this.teamService = teamService;
        this.pictureService = pictureService;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder sb = new StringBuilder();

        PlayersSeedDto[] dtos
                = this.gson.fromJson(readPlayersJsonFile(), PlayersSeedDto[].class);

        Arrays.stream(dtos).forEach(playersSeedDto -> {
            if (this.validationUtil.isValid(playersSeedDto)){
                if (this.playerRepository
                        .findPlayerByNumber(playersSeedDto.getNumber()) == null) {
                    Player mappedPlayer = this.modelMapper.map(playersSeedDto, Player.class);
                    Team team = this.teamService.findTeamByName(playersSeedDto.getTeam().getName());
                    Picture picture = this.pictureService.findPictureByUrl(playersSeedDto.getPicture().getUrl());

                    mappedPlayer.setTeam(team);
                    mappedPlayer.setPicture(picture);

                    this.playerRepository.saveAndFlush(mappedPlayer);

                    sb.append(String.format("Successfully imported player: %s %s",
                                    mappedPlayer.getFirstName(), mappedPlayer.getLastName()))
                            .append(System.lineSeparator());

                }else {
                    sb.append("Invalid player").append(System.lineSeparator());
                }
            } else {
                sb.append("Invalid team").append(System.lineSeparator());
            }
        });


        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return fileUtil.readFile(PLAYER_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        return "";
    }


    @Override
    public String exportPlayersInATeam() {
        //TODO Implement me
        return "";
    }
}
