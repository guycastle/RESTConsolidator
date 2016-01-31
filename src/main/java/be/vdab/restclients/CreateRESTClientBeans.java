package be.vdab.restclients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 30/01/2016 at 13:32.
 */
@Configuration
@ComponentScan
public class CreateRESTClientBeans {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
