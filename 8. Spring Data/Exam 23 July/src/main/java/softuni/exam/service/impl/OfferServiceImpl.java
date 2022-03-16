package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.entities.Offer;
import softuni.exam.models.entities.dto.OfferSeedRootDto;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {
    private final String OFFER_PATH = "src/main/resources/files/xml/offers.xml";
    private OfferRepository offerRepository;
    private SellerRepository sellerRepository;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    private XmlParser xmlParser;
    private CarService carService;
    private SellerService sellerService;

    public OfferServiceImpl(OfferRepository offerRepository,
                            SellerRepository sellerRepository, ValidationUtil validationUtil,
                            ModelMapper modelMapper, XmlParser xmlParser, CarService carService, SellerService sellerService) {
        this.offerRepository = offerRepository;
        this.sellerRepository = sellerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.carService = carService;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files
                .readString(Path.of(OFFER_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(OFFER_PATH, OfferSeedRootDto.class).getOffers().stream()
                .filter(offerSeedDto -> {
                    boolean isValid = validationUtil.isValid(offerSeedDto);
                    sb.append(isValid ? String.format("Successfully import offer %s - %s",
                            offerSeedDto.getAddedOn(), offerSeedDto.getHasGoldStatus())
                                    : "Invalid offer")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(offerSeedDto -> {
                    Offer offer = modelMapper.map(offerSeedDto, Offer.class);
                    offer.setSeller(sellerService.findById(offerSeedDto.getSellerIdDto().getId()));
                    offer.setCar(carService.findById(offerSeedDto.getCarIdDto().getId()));
                    return offer;
                }).forEach(offerRepository::save);

        return sb.toString();
    }
}
