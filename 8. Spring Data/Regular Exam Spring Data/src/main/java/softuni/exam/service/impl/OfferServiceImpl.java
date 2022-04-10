package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.config.GlobalConstants;
import softuni.exam.models.dto.OfferRootSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, AgentRepository agentRepository, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
    }


    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstants.OFFERS_FILES_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        OfferRootSeedDto dtos
                = this.xmlParser.parseXml(OfferRootSeedDto.class, GlobalConstants.OFFERS_FILES_PATH);


        dtos.getOffers().forEach(offerSeedDto -> {
            if (this.validationUtil.isValid(offerSeedDto)){
                if (this.agentRepository.findAgentByFirstName(offerSeedDto.getAgent().getName()) != null){
                    Offer mappedOffer = this.modelMapper.map(offerSeedDto, Offer.class);

                    Agent agent = this.agentRepository.findAgentByFirstName(offerSeedDto.getAgent().getName());
                    Apartment apartment = this.apartmentRepository.findApartmentById(offerSeedDto.getApartment().getId());

                    mappedOffer.setAgent(agent);
                    mappedOffer.setApartment(apartment);

                    this.offerRepository.save(mappedOffer);

                    sb.append(String.format("Successfully imported offer %.2f", mappedOffer.getPrice()))
                            .append(System.lineSeparator());
                } else {
                    sb.append("Invalid offer").append(System.lineSeparator());
                }
            } else {
                sb.append("Invalid offer").append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }

    @Override
    public String exportOffers() {
        return "";
    }
}
