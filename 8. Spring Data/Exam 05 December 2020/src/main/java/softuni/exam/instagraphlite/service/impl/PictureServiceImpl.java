package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.dto.PictureImportDTO;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final Path path = Paths.get("src/main/resources/files/pictures.json");
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.mapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        List<String> list = Files.readAllLines(path);
        return String.join("\n", list);
    }

    @Override
    public String importPictures() throws IOException {
        List<String> message = new ArrayList<>();

        Reader reader = Files.newBufferedReader(path);

        PictureImportDTO[] pictureImportDTOs = this.gson.fromJson(reader, PictureImportDTO[].class);
        Arrays.stream(pictureImportDTOs)
                .forEach(p -> {
                    if (p.isValid()) {
                        Picture pictureByPath = this.pictureRepository.findByPath(p.getPath());
                        if (pictureByPath != null) {
                            message.add("Invalid Picture");
                        } else {
                            Picture picture = this.mapper.map(p, Picture.class);
                            this.pictureRepository.save(picture);
                            message.add(String
                                    .format("Successfully imported Picture, with size %.2f",
                                            picture.getSize()));
                        }
                    } else {
                        message.add("Invalid Picture");
                    }
                });

        return String.join("\n", message);
    }

    @Override
    public String exportPictures() {
        List<String> message = new ArrayList<>();

        List<Picture> allBySizeGreaterThanOrderBySize =
                this.pictureRepository.findAllBySizeGreaterThanOrderBySize(30000);
        allBySizeGreaterThanOrderBySize
                .forEach(p -> message.add(String.format("%.2f - %s%n", p.getSize(), p.getPath())));

        return String.join("", message);
    }
}
