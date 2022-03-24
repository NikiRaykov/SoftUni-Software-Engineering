package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPostDto {

    public ImportPostDto(){}

    @XmlElement
    @NotNull
    @Size(min = 21)
    private String caption;

    @XmlElement
    private UserUsernameDto user;

    @XmlElement
    private PicturePathDto picture;

    public String getCaption() {
        return caption;
    }

    public void setCaption(java.lang.String caption) {
        this.caption = caption;
    }

    public UserUsernameDto getUser() {
        return user;
    }

    public void setUser(UserUsernameDto user) {
        this.user = user;
    }

    public PicturePathDto getPicture() {
        return picture;
    }

    public void setPicture(PicturePathDto picture) {
        this.picture = picture;
    }
}
