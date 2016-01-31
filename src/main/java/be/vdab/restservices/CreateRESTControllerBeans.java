package be.vdab.restservices;

import be.vdab.exceptions.NoRESTClientPropertiesFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.hateoas.config.EnableEntityLinks;

import java.util.Properties;

/**
 * Created on 30/01/2016 at 13:33.
 */
@Configuration
@ComponentScan
@EnableEntityLinks
public class CreateRESTControllerBeans {
    private static final String PROPERTIES_FILENAME = "restClient.properties";

    @Bean(name = "URLProperties")
    Properties properties() {
        Resource resource = new ClassPathResource(PROPERTIES_FILENAME);
        try {
            return PropertiesLoaderUtils.loadProperties(resource);
        } catch (Exception ex) {
            throw new NoRESTClientPropertiesFoundException(ex);
        }
    }
}
