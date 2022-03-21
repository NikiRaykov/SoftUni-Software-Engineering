package softuni.exam.service;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.domain.entities.dto.PlayerSeedDto;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.ValidatorUtilImpl;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;
    public static final String PLAYER_PATH = "src/main/resources/files/json/players.json";
    private Gson gson;
    private ModelMapper modelMapper;
    private ValidatorUtil validatorUtil;
    private TeamService teamService;
    private PictureService pictureService;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, Gson gson, ModelMapper modelMapper, ValidatorUtilImpl validatorUtil, TeamService teamService, PictureService pictureService) {
        this.playerRepository = playerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.teamService = teamService;
        this.pictureService = pictureService;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder sb = new StringBuilder();


        Arrays.stream(gson.fromJson(readPlayersJsonFile(), PlayerSeedDto[].class))
                .forEach(playerSeedDto -> {
                    String firstName = playerSeedDto.getFirstName();
                    String lastName = playerSeedDto.getLastName();

                    if (this.validatorUtil.isValid(playerSeedDto)) {
                        if (this.playerRepository.findByFirstNameAndLastName(firstName, lastName) == null){
                            Player player = this.modelMapper.map(playerSeedDto, Player.class);

                            Team team = this.teamService
                                    .findTeamByName(playerSeedDto.getTeam().getName());

                            Picture picture = this.pictureService
                                    .getPictureByUrl(playerSeedDto.getPicture().getUrl());

                            player.setPicture(picture);
                            player.setTeam(team);

                            this.playerRepository.save(player);

                            sb.append(String.format("Successfully imported player: %s %s",
                                    firstName, lastName));
                        }else {
                            sb.append("Already in database");
                        }
                    } else {
                        sb.append("Invalid player");
                    }

                    sb.append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYER_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();

        this.playerRepository.findAllBySalaryGreaterThan(BigDecimal.valueOf(100000))
                .forEach(player -> {
                    sb.append(String.format("Player name: %s %s",
                            player.getFirstName(), player.getLastName()))
                            .append(System.lineSeparator())
                            .append(String.format("Number: %d ", player.getNumber()))
                            .append(System.lineSeparator())
                            .append(String.format("Salary: %.2f", player.getSalary()))
                            .append(System.lineSeparator())
                            .append(String.format("Team: %s", player.getTeam().getName()))
                            .append(System.lineSeparator());
                });


        return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder();

       this.playerRepository.findByTeamNameOrderById("North Hub")
                .forEach(player -> {
                    sb.append(String.format("Team: %s", player.getTeam().getName()))
                            .append(System.lineSeparator())
                            .append(String.format("Player name: %s %s - %s",
                                    player.getFirstName(), player.getLastName(),
                                    player.getPosition())).append(System.lineSeparator())
                            .append(String.format("Number: %d ", player.getNumber()))
                            .append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
