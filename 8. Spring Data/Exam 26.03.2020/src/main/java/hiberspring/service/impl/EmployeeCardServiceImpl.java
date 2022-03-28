package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.dto.EmployeeCardSeedDto;
import hiberspring.domain.entity.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {
    private final EmployeeCardRepository employeeCardRepository;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.employeeCardRepository = employeeCardRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.EMPLOYEE_CARDS_FILE_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        EmployeeCardSeedDto[] employeeCardSeedDtos
                = this.gson.fromJson(readEmployeeCardsJsonFile(), EmployeeCardSeedDto[].class);

        Arrays.stream(employeeCardSeedDtos)
                .forEach(employeeCardSeedDto -> {
                    if (validationUtil.isValid(employeeCardSeedDto)) {
                        if (this.employeeCardRepository
                                .findEmployeeCardByNumber(employeeCardSeedDto.getNumber()) == null){
                            EmployeeCard mappedEmplCard
                                    = this.modelMapper.map(employeeCardSeedDto, EmployeeCard.class);

                            this.employeeCardRepository.saveAndFlush(mappedEmplCard);

                            sb.append(String.format("Successfully imported Employee Card %s.",
                                    employeeCardSeedDto.getNumber())).append(System.lineSeparator());
                        }else{
                            sb.append(GlobalConstants
                                    .INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                        }
                    } else {
                        sb.append(GlobalConstants
                                .INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
