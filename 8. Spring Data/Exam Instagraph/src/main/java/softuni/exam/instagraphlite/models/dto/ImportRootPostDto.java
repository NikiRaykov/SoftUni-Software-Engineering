package softuni.exam.instagraphlite.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportRootPostDto {

    @XmlElement(name = "post")
    private List<ImportPostDto> posts;

    public List<ImportPostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<ImportPostDto> posts) {
        this.posts = posts;
    }
}
