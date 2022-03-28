package hiberspring.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "employeeCards")
public class EmployeeCard {

    public EmployeeCard(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
