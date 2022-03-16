package softuni.exam.models.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    @Column(length = 20, unique = true)
    private String name;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @ManyToOne
    private Car car;

    public Picture() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
