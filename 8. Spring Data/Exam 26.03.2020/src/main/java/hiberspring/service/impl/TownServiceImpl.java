package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.dto.TownSeedDto;
import hiberspring.domain.entity.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns(String townsFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        TownSeedDto[] townSeedDtos
                = this.gson.fromJson(readTownsJsonFile(), TownSeedDto[].class);

        Arrays.stream(townSeedDtos).filter(townSeedDto -> {
            boolean isValid = validationUtil.isValid(townSeedDto);

            sb.append(isValid ? String.format("Successfully imported Town-%s",
                            townSeedDto.getName())
                            : "Error: Invalid data.")
                    .append(System.lineSeparator());

            return isValid;

        }).map(townSeedDto -> this.modelMapper.map(townSeedDto, Town.class))
                .forEach(townRepository::save);

        return sb.toString().trim();
    }
}
