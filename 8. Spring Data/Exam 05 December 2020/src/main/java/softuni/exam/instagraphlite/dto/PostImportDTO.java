package softuni.exam.instagraphlite.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDTO {
    @XmlElement
    private String caption;
    @XmlElement(name = "user")
    private UserUsernameDTO userUsernameDTO;
    @XmlElement(name = "picture")
    private PicturePathDTO picturePathDTO;

    public PostImportDTO() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UserUsernameDTO getUserUsernameDTO() {
        return userUsernameDTO;
    }

    public void setUserUsernameDTO(UserUsernameDTO userUsernameDTO) {
        this.userUsernameDTO = userUsernameDTO;
    }

    public PicturePathDTO getPicturePathDTO() {
        return picturePathDTO;
    }

    public void setPicturePathDTO(PicturePathDTO picturePathDTO) {
        this.picturePathDTO = picturePathDTO;
    }

    public boolean isValid() {
        if (this.caption == null || this.caption.length() < 21) {
            return false;
        }
        return true;
    }
}
