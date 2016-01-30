package be.vdab.restclients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 30/01/2016 at 13:26.
 */
@Component
public class DigitalVaultClient extends AbstractClient {

    @Autowired
    public DigitalVaultClient(@Value("${DigitalVaultURL}") String URL, RestTemplate restTemplate) {
        this.URL = URL;
        this.restTemplate = restTemplate;
    }
}
