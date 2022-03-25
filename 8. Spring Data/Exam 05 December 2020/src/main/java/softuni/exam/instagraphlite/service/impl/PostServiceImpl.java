package softuni.exam.instagraphlite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.dto.PostsImportDTO;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final Path path = Paths.get("src/main/resources/files/posts.xml");

    @Autowired
    public PostServiceImpl(PostRepository postRepository,
                           PictureRepository pictureRepository,
                           UserRepository userRepository) {
        this.postRepository = postRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        List<String> list = Files.readAllLines(path);
        return String.join("\n", list);
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        List<String> message = new ArrayList<>();

        JAXBContext context = JAXBContext.newInstance(PostsImportDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Reader reader = Files.newBufferedReader(path);
        PostsImportDTO postsImportDTO = (PostsImportDTO) unmarshaller.unmarshal(reader);
        postsImportDTO.getPosts()
                .forEach(p -> {
                    if (p.isValid()) {
                        Picture pictureByPath = this.pictureRepository.findByPath(p.getPicturePathDTO().getPath());
                        User userByUsername = this.userRepository.findByUsername(p.getUserUsernameDTO().getUsername());
                        if (pictureByPath != null && userByUsername != null) {
                            Post post = new Post();
                            post.setCaption(p.getCaption());
                            post.setUser(userByUsername);
                            post.setPicture(pictureByPath);
                            this.postRepository.save(post);
                            message.add(String.format("Successfully imported Post, made by %s",
                                    post.getUser().getUsername()));
                        } else {
                            message.add("Invalid Post");
                        }
                    } else {
                        message.add("Invalid Post");
                    }
                });

        return String.join("\n", message);
    }
}
