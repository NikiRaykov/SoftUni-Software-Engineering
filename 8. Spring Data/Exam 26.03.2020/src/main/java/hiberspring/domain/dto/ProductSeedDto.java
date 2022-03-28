package hiberspring.domain.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedDto {

    public ProductSeedDto(){}

    @XmlAttribute
    @NotNull
    private String name;

    @XmlAttribute
    @NotNull
    private Integer clients;

    @XmlElement
    @NotNull
    private String branch;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }
}
