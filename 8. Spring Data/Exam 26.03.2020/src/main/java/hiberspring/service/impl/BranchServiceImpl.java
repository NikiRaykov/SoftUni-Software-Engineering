package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.dto.BranchSeedDto;
import hiberspring.domain.entity.Branch;
import hiberspring.domain.entity.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.TownRepository;
import hiberspring.service.BranchService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.branchRepository = branchRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.BRANCHES_FILE_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        BranchSeedDto[] branchSeedDtos
                = this.gson.fromJson(readBranchesJsonFile(), BranchSeedDto[].class);

        Arrays.stream(branchSeedDtos)
                .filter(branchSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(branchSeedDto);
                    sb.append(isValid ? String.format("Successfully imported Town-%s",
                                    branchSeedDto.getName())
                                    : "Error: Invalid data.")
                            .append(System.lineSeparator());

                    return isValid;

                }).map(branchSeedDto -> modelMapper.map(branchSeedDto, Branch.class))
                .forEach(branchRepository::save);

        return sb.toString().trim();
    }
}
