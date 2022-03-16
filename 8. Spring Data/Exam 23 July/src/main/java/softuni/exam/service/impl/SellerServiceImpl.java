package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.entities.Seller;
import softuni.exam.models.entities.dto.SellerSeedRootDto;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {
    private final String SELLER_PATH = "src/main/resources/files/xml/sellers.xml";
    private SellerRepository sellerRepository;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    private XmlParser xmlParser;

    public SellerServiceImpl(SellerRepository sellerRepository, ValidationUtil validationUtil,
                             ModelMapper modelMapper, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_PATH));
    }

    @Override
    public String importSellers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();


        xmlParser
                .fromFile(SELLER_PATH, SellerSeedRootDto.class)
                .getSellers().stream().filter(sellerSeedDto -> {
                    boolean isValid = validationUtil.isValid(sellerSeedDto);
                    sb.append(isValid ? String.format("Successfully imported seller %s - %s",
                                    sellerSeedDto.getFirstName(), sellerSeedDto.getEmail())
                                    : "Invalid seller")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(sellerSeedDto -> modelMapper.map(sellerSeedDto, Seller.class))
                .forEach(sellerRepository::save);

        return sb.toString();
    }

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }
}

