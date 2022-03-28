package hiberspring.service.impl;

import hiberspring.common.GlobalConstants;
import hiberspring.domain.dto.ProductRootSeedDto;
import hiberspring.domain.entity.Branch;
import hiberspring.domain.entity.Product;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.ProductRepository;
import hiberspring.service.ProductService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static hiberspring.common.GlobalConstants.PRODUCTS_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final BranchRepository branchRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, BranchRepository branchRepository) {
        this.productRepository = productRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(PRODUCTS_FILE_PATH));
    }

    @Override
    public String importProducts() throws JAXBException, IOException {
        StringBuilder sb = new StringBuilder();

        ProductRootSeedDto productRootSeedDto
                = this.xmlParser.parseXml(ProductRootSeedDto.class, PRODUCTS_FILE_PATH);

        productRootSeedDto.getProducts()
                .forEach(productSeedDto -> {
                    if (this.validationUtil.isValid(productSeedDto)) {
                        if (this.productRepository.findProductByName(productSeedDto.getBranch()) == null) {

                            Product mappedProduct = this.modelMapper.map(productSeedDto, Product.class);

                            Branch branch = this.branchRepository.findByName(productSeedDto.getBranch());

                            mappedProduct.setBranch(branch);
                            this.productRepository.saveAndFlush(mappedProduct);

                            sb.append(String.format("Successfully imported Product %s.",
                                    productSeedDto.getName())).append(System.lineSeparator());
                        } else {
                            sb.append(GlobalConstants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                        }

                    } else {
                        sb.append(GlobalConstants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
