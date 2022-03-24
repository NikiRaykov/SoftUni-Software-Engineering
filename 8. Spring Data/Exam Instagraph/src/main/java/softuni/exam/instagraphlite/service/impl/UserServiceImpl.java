package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dto.ImportUserDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    public static final String USER_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;

        this.gson = new GsonBuilder().create();

        this.validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();

        this.modelMapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files
                .readString(Path.of(USER_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();

        ImportUserDto[] importUserDto =
                this.gson.fromJson(readFromFileContent(), ImportUserDto[].class);

        for (ImportUserDto userDto : importUserDto) {
            Set<ConstraintViolation<ImportUserDto>> validationErrors =
                    this.validator.validate(userDto);

            if(validationErrors.isEmpty()){
                User mappedUser = this.modelMapper.map(userDto, User.class);

                Optional<Picture> optPic =
                        this.pictureRepository
                                .findPictureByPath(userDto.getProfilePicture());

                if (optPic.isPresent()){
                    mappedUser.setProfilePicture(optPic.get());
                    this.userRepository.save(mappedUser);

                    sb.append(String.format("Successfully imported User: %s",
                            mappedUser.getUsername()));
                }else {
                    sb.append("Invalid user");
                }
            }else {
                sb.append("Invalid user");
            }

            sb.append(System.lineSeparator());
        }

            return sb.toString().trim();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();

        this.userRepository.findByPostsOrderByIdDesc()
                .stream()
                .forEach(user -> {
                    sb.append(String.format("User: %s", user.getUsername()))
                            .append(System.lineSeparator())
                            .append(String.format("Post count: %d", user.getPosts().size()))
                            .append(System.lineSeparator())
                            .append("==Post Details: ")
                            .append(System.lineSeparator())
                            .append(String.format("----Caption: %s", user.getUsername()))
                            .append(System.lineSeparator())
                            .append(String.format("----Picture Size: %.2f", user.getProfilePicture().getSize()));
                });

        return sb.toString().trim();
    }
}
