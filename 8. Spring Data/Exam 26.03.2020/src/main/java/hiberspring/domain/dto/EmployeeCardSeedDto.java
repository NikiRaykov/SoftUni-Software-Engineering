package hiberspring.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class EmployeeCardSeedDto {

    public EmployeeCardSeedDto(){}

    @Expose
    private String number;

    @NotNull
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
