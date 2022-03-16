import dto.EmployeeDto;
import dto.ManagerDto;
import entities.Address;
import entities.Employee;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;


public class MapperMain {
    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper();

        Address address = new Address("rodina", 66);

        Employee manager = new Employee("Mr.", "Manager",
                BigDecimal.TEN,
                LocalDate.now(),
                address,
                true);

        Employee first = new Employee("Mr.", "First",
                BigDecimal.TEN,
                LocalDate.now(),
                address,
                true);

        Employee second = new Employee("Mr.", "second",
                BigDecimal.TEN,
                LocalDate.now(),
                address,
                true);

        ManagerDto managerDto = mapper.map(manager, ManagerDto.class);
        managerDto.addEmployee(manager);

        System.out.println(managerDto);

    }
}
