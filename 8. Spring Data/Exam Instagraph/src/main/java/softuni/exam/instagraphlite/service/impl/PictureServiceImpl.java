package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.dto.ImportPictureDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class PictureServiceImpl implements PictureService {
    public static final String PICTURE_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;

        this.gson = new GsonBuilder().create();

        this.modelMapper = new ModelMapper();

        this.validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        String json = this.readFromFileContent();
        ImportPictureDto[] importPictureDtos =
                this.gson.fromJson(json, ImportPictureDto[].class);

        for (ImportPictureDto importPictureDto : importPictureDtos) {
            Set<ConstraintViolation<ImportPictureDto>> validateErrors =
                    this.validator.validate(importPictureDto);

            if (validateErrors.isEmpty()){
                Picture mappedPicture =
                        this.modelMapper.map(importPictureDto, Picture.class);

                this.pictureRepository.save(mappedPicture);

                sb.append(String.format("Successfully imported Picture, with size %.2f",
                        mappedPicture.getSize()));
            } else {
                sb.append("Invalid picture");
            }

            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();

        this.pictureRepository.findPictureBySizeGreaterThanOrderBySize()
                .forEach(p -> sb.
                        append(System.out.printf("%.2f - %s", p.getSize(), p.getPath())
                                .append(System.lineSeparator())));

        return sb.toString().trim();
    }
}
