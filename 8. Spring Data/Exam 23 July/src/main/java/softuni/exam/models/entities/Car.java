package softuni.exam.models.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{

    @Column(length = 20)
    private String make;

    @Column(length = 20)
    private String model;

    @Column
    private Integer kilometers;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    @Column(name = "registed_on")
    private LocalDate registeredOn;

    public Car() {
    }

    public Car(String make, String model, Integer kilometers, LocalDate registeredOn) {
        this.make = make;
        this.model = model;
        this.kilometers = kilometers;
        this.registeredOn = registeredOn;
    }

    public String getMake() {
        return make;
    }


    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
