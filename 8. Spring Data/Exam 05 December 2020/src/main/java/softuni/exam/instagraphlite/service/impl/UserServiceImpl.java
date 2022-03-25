package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.dto.UserImportDTO;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final Path path = Paths.get("src/main/resources/files/users.json");
    private final Gson gson;
    private final ModelMapper mapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.mapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        List<String> list = Files.readAllLines(path);
        return String.join("\n", list);
    }

    @Override
    public String importUsers() throws IOException {
        List<String> message = new ArrayList<>();

        Reader reader = Files.newBufferedReader(path);
        UserImportDTO[] userImportDTOs = this.gson.fromJson(reader, UserImportDTO[].class);
        Arrays.stream(userImportDTOs)
                .forEach(u -> {
                    if (u.isValid()) {
                        User userByUsername = this.userRepository.findByUsername(u.getUsername());
                        if (userByUsername != null) {
                            message.add("Invalid User");
                        } else {
                            Picture pictureByPath = this.pictureRepository.findByPath(u.getProfilePicture());
                            if (pictureByPath != null) {
                                User user = this.mapper.map(u, User.class);
                                user.setProfilePicture(pictureByPath);
                                this.userRepository.save(user);
                                message.add(String.format("Successfully imported User: %s", user.getUsername()));
                            } else {
                                message.add("Invalid User");
                            }
                        }
                    } else {
                        message.add("Invalid User");
                    }
                });

        return String.join("\n", message);
    }

    @Override
    public String exportUsersWithTheirPosts() {
        List<String> message = new ArrayList<>();

        Set<User> allOrderByPostsSizeDescAndId = this.userRepository.findAllOrderBySizePostsDescAndId();

        allOrderByPostsSizeDescAndId
                .forEach(u -> {
                    Set<Post> posts = u.getPosts();
                    posts = posts.stream()
                            .sorted(Comparator.comparingDouble(p -> p.getPicture().getSize())).collect(Collectors.toCollection(LinkedHashSet::new));
                    u.setPosts(posts);
                });

        for (User user : allOrderByPostsSizeDescAndId) {
            message.add(String.format("User: %s%nPost count: %d%n", user.getUsername(), user.getPosts().size()));
            for (Post post : user.getPosts()) {
                message.add(String.format("==Post Details:%n" +
                        "----Caption: %s%n" +
                        "----Picture Size: %.2f%n", post.getCaption(), post.getPicture().getSize()));
            }
        }

        return String.join("", message);
    }
}
