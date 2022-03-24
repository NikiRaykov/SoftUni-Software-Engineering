package softuni.exam.instagraphlite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.instagraphlite.util.XmlParser;
import softuni.exam.instagraphlite.util.impl.XmlParserImpl;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public XmlParser xmlParser() {
        return new XmlParserImpl();
    }
}
