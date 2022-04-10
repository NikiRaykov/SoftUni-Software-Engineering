package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.config.GlobalConstants;
import softuni.exam.models.dto.ApartmentRootSeedDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, TownRepository townRepository) {
        this.apartmentRepository = apartmentRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.APARTMENTS_FILES_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        ApartmentRootSeedDto dtos
                = this.xmlParser.parseXml(ApartmentRootSeedDto.class, GlobalConstants.APARTMENTS_FILES_PATH);

        dtos.getApartments()
                .forEach(apartmentSeedDto -> {
                    if (this.validationUtil.isValid(apartmentSeedDto)){
                        if (this.apartmentRepository.findApartmentByTownAndArea(apartmentSeedDto.getTown().getName(), apartmentSeedDto.getArea()) == null){
                            Apartment mappedApartment = this.modelMapper.map(apartmentSeedDto, Apartment.class);
                            Town town = this.townRepository.findTownByTownName(apartmentSeedDto.getTown().getName());

                            mappedApartment.setTown(town);
                            this.apartmentRepository.save(mappedApartment);

                            sb.append(String.format("Successfully imported apartment %s - %.2f", mappedApartment.getApartmentType(),
                                    apartmentSeedDto.getArea())).append(System.lineSeparator());

                        } else {
                            sb.append("Invalid apartment").append(System.lineSeparator());
                        }
                    } else {
                        sb.append("Invalid apartment").append(System.lineSeparator());
                    }
                });


        return sb.toString().trim();
    }
}
