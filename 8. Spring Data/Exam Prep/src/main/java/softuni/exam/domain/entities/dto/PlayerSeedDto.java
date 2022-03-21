package softuni.exam.domain.entities.dto;


import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PlayerSeedDto {
    public PlayerSeedDto(){}

    @Expose
    @NotNull
    private String firstName;

    @Expose
    @NotNull
    @Min(value = 3)
    @Max(value = 15)
    private String lastName;

    @Expose
    @NotNull
    @Min(value = 1)
    @Max(value = 99)
    private Integer number;

    @Expose
    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal salary;

    @Expose
    @NotNull
    private String position;

    @Expose
    @NotNull
    private PictureSeedDto picture;

    @Expose
    @NotNull
    private TeamSeedDto team;

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

    public PictureSeedDto getPicture() {
        return picture;
    }

    public void setPicture(PictureSeedDto picture) {
        this.picture = picture;
    }

    public TeamSeedDto getTeam() {
        return team;
    }

    public void setTeam(TeamSeedDto team) {
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
