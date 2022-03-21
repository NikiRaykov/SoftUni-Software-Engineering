package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.domain.entities.dto.TeamSeedRootDto;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtilImpl;
import softuni.exam.util.XmlParser;


import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    public static final String TEAM_PATH = "src/main/resources/files/xml/teams.xml";
    private TeamRepository teamRepository;
    private ValidatorUtilImpl validatorUtil;
    private ModelMapper modelMapper;
    private XmlParser xmlParser;
    private PictureService pictureService;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, ValidatorUtilImpl validatorUtil, ModelMapper modelMapper, XmlParser xmlParser, PictureService pictureService) {
        this.teamRepository = teamRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.pictureService = pictureService;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TeamSeedRootDto teamSeedRootDto =
                this.xmlParser.fromFile(TEAM_PATH, TeamSeedRootDto.class);


        teamSeedRootDto.getTeams().forEach(teamSeedDto -> {
            if (validatorUtil.isValid(teamSeedDto)) {
                if (this.teamRepository.findByName(teamSeedDto.getName()) == null) {
                    Team mappedTeam = modelMapper.map(teamSeedDto, Team.class);

                    Picture picture = this.pictureService
                            .getPictureByUrl(teamSeedDto.getPictureDto().getUrl());

                    mappedTeam.setPicture(picture);

                    this.teamRepository.saveAndFlush(mappedTeam);
                    sb.append(String.format("Successfully imported - %s", teamSeedDto.getName()));
                } else {
                    sb.append("Already in the database");
                }
            } else{
                sb.append("Invalid team");
            }
            sb.append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(TEAM_PATH));
    }

    @Override
    public Team findTeamByName(String name) {
        return this.teamRepository
                .findByName(name);
    }
}
