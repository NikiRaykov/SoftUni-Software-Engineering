package hiberspring.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    public Product(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "clients", nullable = false)
    private Integer clients;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Branch branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    @Column(nullable = false)
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
