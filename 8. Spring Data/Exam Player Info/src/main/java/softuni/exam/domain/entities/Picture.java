package softuni.exam.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {

    public Picture(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
