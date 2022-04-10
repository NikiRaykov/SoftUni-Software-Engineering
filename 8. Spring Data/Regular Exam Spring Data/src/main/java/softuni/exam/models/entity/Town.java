package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "town_name", unique = true, nullable = false)
    private String townName;

    @Column(name = "population", nullable = false)
    private int population;

    @OneToMany(mappedBy = "town")
    private Set<Apartment> apartments;

    public Town(){}

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }
}
