package hiberspring.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeRootSeedDto {

    public EmployeeRootSeedDto(){}

    @XmlElement(name = "employee")
    private List<EmployeeSeedDto> employees;

    public List<EmployeeSeedDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeSeedDto> employees) {
        this.employees = employees;
    }
}
