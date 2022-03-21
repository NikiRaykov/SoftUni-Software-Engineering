package softuni.exam.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    public Team(){}

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Picture picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
