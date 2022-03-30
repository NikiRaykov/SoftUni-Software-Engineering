package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.TeamRootSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.service.TeamService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class TeamServiceImpl implements TeamService {
    public static final String TEAM_FILES_PATH = "src/main/resources/files/xml/teams.xml";

    private final FileUtil fileUtil;
    private final TeamRepository teamRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PictureRepository pictureRepository;

    @Autowired
    public TeamServiceImpl(FileUtil fileUtil, TeamRepository teamRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, PictureRepository pictureRepository) {
        this.fileUtil = fileUtil;
        this.teamRepository = teamRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TeamRootSeedDto dtos
                = this.xmlParser.parseXml(TeamRootSeedDto.class, TEAM_FILES_PATH);

        dtos.getTeams().forEach(teamSeedDto -> {
            if (this.validationUtil.isValid(teamSeedDto)){
                if (this.teamRepository.findTeamByName(teamSeedDto.getName()) == null){
                    Team mappedTeam =
                            this.modelMapper.map(teamSeedDto, Team.class);

                    Picture picture =
                            this.pictureRepository
                                    .findPictureByUrl(teamSeedDto.getPicture().getUrl());

                    mappedTeam.setPicture(picture);
                    this.teamRepository.saveAndFlush(mappedTeam);

                    sb.append(String.format("Successfully imported - %s",
                                    mappedTeam.getName()))
                            .append(System.lineSeparator());
                }else {
                    sb.append("Invalid team ").append(System.lineSeparator());
                }
            } else {
                sb.append("Invalid team ").append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return this.fileUtil.readFile(TEAM_FILES_PATH);
    }

    @Override
    public Team findTeamByName(String name) {
        return this.teamRepository.findTeamByName(name);
    }
}
