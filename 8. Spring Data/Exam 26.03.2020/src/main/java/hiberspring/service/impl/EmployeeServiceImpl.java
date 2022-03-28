package hiberspring.service.impl;

import hiberspring.common.GlobalConstants;
import hiberspring.domain.dto.EmployeeRootSeedDto;
import hiberspring.domain.entity.Branch;
import hiberspring.domain.entity.Employee;
import hiberspring.domain.entity.EmployeeCard;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final EmployeeCardRepository employeeCardRepository;
    private final BranchRepository branchRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, XmlParser xmlParser, ModelMapper modelMapper, EmployeeCardRepository employeeCardRepository, BranchRepository branchRepository, ValidationUtil validationUtil) {
        this.employeeRepository = employeeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.employeeCardRepository = employeeCardRepository;
        this.branchRepository = branchRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.EMPLOYEES_FILE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        EmployeeRootSeedDto employeeRootSeedDto = this.xmlParser.parseXml(EmployeeRootSeedDto.class, GlobalConstants.EMPLOYEES_FILE_PATH);

        employeeRootSeedDto.getEmployees()
                .forEach(employeeSeedDto -> {
                    if (this.validationUtil.isValid(employeeSeedDto)){
                        if (this.employeeRepository
                                .findByFirstNameAndLastName(employeeSeedDto.getFirstName(), employeeSeedDto.getLastName()) == null){

                            Employee mappedEmployee = this.modelMapper.map(employeeSeedDto, Employee.class);

                            EmployeeCard card = this.employeeCardRepository.findEmployeeCardByNumber(employeeSeedDto.getCard());
                            Branch branch = this.branchRepository.findByName(employeeSeedDto.getBranch());

                            mappedEmployee.setCard(card);
                            mappedEmployee.setBranch(branch);

                            this.employeeRepository.saveAndFlush(mappedEmployee);

                            sb.append(String.format("Successfully imported Employee %s %s.",
                                    mappedEmployee.getFirstName(), mappedEmployee.getLastName())).append(System.lineSeparator());

                        }else {
                            sb.append(GlobalConstants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                        }
                    } else {
                        sb.append(GlobalConstants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                    }
                });


        return sb.toString().trim();
    }

    @Override
    public String exportProductiveEmployees() {
        return this.employeeRepository.findAllByBranchWithMoreThanOneProduct()
                .stream()
                .map(employee -> String.format("Name: %s %s%n, Position: %s%n, " +
                        "Card number: %s%n", employee.getFirstName(),
                        employee.getLastName(), employee.getPosition(),
                        employee.getCard().getNumber()))
                .collect(Collectors.joining("-------------------------"));
    }
}
