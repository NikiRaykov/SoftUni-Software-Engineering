package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PictureRootSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {
    public static final String PICTURE_PATH = "src/main/resources/files/xml/pictures.xml";

    private final FileUtil fileUtil;
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;


    @Autowired
    public PictureServiceImpl(FileUtil fileUtil, PictureRepository pictureRepository,
                              ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.fileUtil = fileUtil;
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public String importPictures() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        PictureRootSeedDto dtos
                = this.xmlParser.parseXml(PictureRootSeedDto.class, PICTURE_PATH);

        dtos.getPictures().forEach(pictureSeedDto -> {
            if (this.validationUtil.isValid(pictureSeedDto)){
                String url = pictureSeedDto.getUrl();

                if (this.pictureRepository.findPictureByUrl(url) == null){

                    Picture mappedPicture = this.modelMapper.map(pictureSeedDto, Picture.class);

                   this.pictureRepository.saveAndFlush(mappedPicture);

                   sb.append(String.format("Successfully imported picture - %s",
                                   mappedPicture.getUrl()))
                           .append(System.lineSeparator());

                }else {
                    sb.append("Invalid picture").append(System.lineSeparator());
                }
            } else {
                sb.append("Invalid picture").append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return fileUtil.readFile(PICTURE_PATH);
    }

    @Override
    public Picture findPictureByUrl(String url) {
        return this.pictureRepository.findPictureByUrl(url);
    }

}
