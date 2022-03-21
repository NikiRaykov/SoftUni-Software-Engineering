package softuni.exam.domain.entities.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamSeedDto {

    public TeamSeedDto(){}

    @XmlElement(name = "name")
    @NotNull
    @Length(min = 3, max = 20)
    @Expose
    private String name;

    @XmlElement(name = "picture")
    @NotNull
    @Expose
    private PictureSeedDto picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureSeedDto getPictureDto() {
        return picture;
    }

    public void setPictureDto(PictureSeedDto picture) {
        this.picture = picture;
    }
}
