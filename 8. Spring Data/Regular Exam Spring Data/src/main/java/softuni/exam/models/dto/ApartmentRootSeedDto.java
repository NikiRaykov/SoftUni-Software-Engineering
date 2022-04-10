package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentRootSeedDto {

    public ApartmentRootSeedDto(){}

    @XmlElement(name = "apartment")
    private List<ApartmentSeedDto> apartments;

    public List<ApartmentSeedDto> getApartments() {
        return apartments;
    }

    public void setApartments(List<ApartmentSeedDto> apartments) {
        this.apartments = apartments;
    }
}
