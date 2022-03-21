package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.dto.PictureSeedDto;
import softuni.exam.domain.entities.dto.PictureSeedRootDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.ValidatorUtilImpl;
import softuni.exam.util.XmlParser;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Service
public class PictureServiceImpl implements PictureService {
    private PictureRepository pictureRepository;
    private ValidatorUtilImpl validatorUtil;
    private ModelMapper modelMapper;
    private XmlParser xmlParser;
    public static final String PICTURE_PATH = "src/main/resources/files/xml/pictures.xml";

    public PictureServiceImpl(PictureRepository pictureRepository,
                             ValidatorUtilImpl validatorUtil,
                              ModelMapper modelMapper, XmlParser xmlParser) {
        this.pictureRepository = pictureRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public String importPictures() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        PictureSeedRootDto pictureSeedRootDto =
                this.xmlParser.fromFile(PICTURE_PATH, PictureSeedRootDto.class);

        pictureSeedRootDto.getPictures().stream()
                .filter(pictureSeedDto -> {
                    boolean isValid = validatorUtil.isValid(pictureSeedDto);
                    sb.append(isValid ? String.format("Successfully imported picture - %s",
                            pictureSeedDto.getUrl())
                            : "Invalid picture")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(pictureSeedDto -> modelMapper.map(pictureSeedDto, Picture.class))
                .forEach(pictureRepository::save);

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Path.of(PICTURE_PATH));
    }

    @Override
    public Picture getPictureByUrl(String url) {
        return this.pictureRepository.findByUrl(url);
    }
}
