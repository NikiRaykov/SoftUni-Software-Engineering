package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.config.GlobalConstants;
import softuni.exam.models.dto.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, TownRepository townRepository) {
        this.agentRepository = agentRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.AGENTS_FILES_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder sb = new StringBuilder();

        AgentSeedDto[] dtos
                = this.gson.fromJson(readAgentsFromFile(), AgentSeedDto[].class);

        Arrays.stream(dtos)
                .forEach(agentSeedDto -> {
                    if (this.validationUtil.isValid(agentSeedDto)){
                        if (this.agentRepository
                                .findAgentByFirstName(agentSeedDto.getFirstName()) == null){

                            Agent mappedAgent = this.modelMapper.map(agentSeedDto, Agent.class);
                            Town town = this.townRepository.findTownByTownName(agentSeedDto.getTown());

                            mappedAgent.setTown(town);

                            this.agentRepository.save(mappedAgent);

                            sb.append(String.format("Successfully imported agent - %s %s",
                                            mappedAgent.getFirstName(), mappedAgent.getLastName()))
                                    .append(System.lineSeparator());

                        } else {
                            sb.append("Invalid agent").append(System.lineSeparator());
                        }
                    } else {
                        sb.append("Invalid agent").append(System.lineSeparator());
                    }
                });


        return sb.toString().trim();
    }
}
