package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.config.GlobalConstants;
import softuni.exam.models.dto.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository,
                           ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstants.TOWNS_FILES_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder sb = new StringBuilder();

        TownSeedDto[] dtos
                = this.gson.fromJson(readTownsFileContent(), TownSeedDto[].class);

        Arrays.stream(dtos).forEach(townSeedDto -> {
            if (this.validationUtil.isValid(townSeedDto)){
                if (this.townRepository.findTownByTownName(townSeedDto.getTownName()) == null){

                    Town mappedTown = this.modelMapper.map(townSeedDto, Town.class);

                    this.townRepository.save(mappedTown);

                    sb.append(String.format("Successfully imported town %s - %d",
                                    mappedTown.getTownName(), mappedTown.getPopulation()))
                            .append(System.lineSeparator());

                } else {
                    sb.append("Invalid town").append(System.lineSeparator());
                }
            } else {
                sb.append("Invalid town").append(System.lineSeparator());
            }
        });


        return sb.toString().trim();
    }
}
