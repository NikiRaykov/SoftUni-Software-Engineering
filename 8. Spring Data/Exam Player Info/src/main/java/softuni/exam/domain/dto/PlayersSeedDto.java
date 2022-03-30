package softuni.exam.domain.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;
import softuni.exam.domain.Position;
import softuni.exam.util.impl.EnumValidator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Arrays;

public class PlayersSeedDto {

    public PlayersSeedDto(){}

    @Expose()
    @NotNull
    private String firstName;

    @Expose()
    @NotNull
    @Length(min = 3, max = 15)
    private String lastName;

    @Expose
    @NotNull
    @Min(value = 1)
    @Max(value = 99)
    private Integer number;

    @Expose
    @NotNull
    @Min(value = 0)
    private BigDecimal salary;

    @Expose
    @NotNull
    @EnumValidator(enumClass = Position.class)
    private String position;

    @Expose
    @NotNull
    private TeamSeedDto team;

    @Expose
    @NotNull
    private PictureSeedDto picture;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public TeamSeedDto getTeam() {
        return team;
    }

    public void setTeam(TeamSeedDto team) {
        this.team = team;
    }

    public PictureSeedDto getPicture() {
        return picture;
    }

    public void setPicture(PictureSeedDto picture) {
        this.picture = picture;
    }

}
