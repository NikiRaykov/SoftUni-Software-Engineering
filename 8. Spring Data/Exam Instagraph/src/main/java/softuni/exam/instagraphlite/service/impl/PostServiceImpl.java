package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dto.ImportPostDto;
import softuni.exam.instagraphlite.models.dto.ImportRootPostDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final Path path =
            Path.of("src", "main", "resources", "files", "posts.xml");

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Unmarshaller unmarshaller;
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository,
                           PictureRepository pictureRepository, UserRepository userRepository) throws JAXBException {
        this.postRepository = postRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;

        JAXBContext context = JAXBContext.newInstance(ImportRootPostDto.class);
        this.unmarshaller = context.createUnmarshaller();

        this.validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();

        this.modelMapper = new ModelMapper();

    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importPosts() throws JAXBException, FileNotFoundException {
        ImportRootPostDto rootDTOs = (ImportRootPostDto) this.unmarshaller.unmarshal(
                new FileReader(path.toAbsolutePath().toString()));

        return rootDTOs
                .getPosts()
                .stream()
                .map(this::importPost)
                .collect(Collectors.joining("\n"));
    }

    private String importPost(ImportPostDto dto) {
        StringBuilder sb = new StringBuilder();

        Set<ConstraintViolation<ImportPostDto>> errors =
                this.validator.validate(dto);


        if (errors.isEmpty()) {
            Post mappedPost = this.modelMapper.map(dto, Post.class);

            Optional<Picture> optPic =
                    this.pictureRepository
                            .findPictureByPath(dto.getPicture().getPath());

            Optional<User> optUser =
                    this.userRepository
                            .findUserByUsername(dto.getUser().getUsername());


            if (optPic.isPresent() && optUser.isPresent()) {
                mappedPost.setUser(optUser.get());
                mappedPost.setPicture(optPic.get());

                this.postRepository.save(mappedPost);

                sb.append(String.format("Successfully imported Post, made by %s",
                        mappedPost.getUser().getUsername()));
            }else {
                sb.append("Invalid Post");
            }
        } else {
                sb.append("Invalid Post");
            }

        return sb.toString().trim();
    }
}
