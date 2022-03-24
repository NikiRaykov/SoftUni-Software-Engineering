package softuni.exam.instagraphlite.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserUsernameDto {
    @XmlElement
    private String username;

    public UserUsernameDto() {
    }

    public String getUsername() {
        return username;
    }
}
