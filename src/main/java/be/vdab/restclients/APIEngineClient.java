package be.vdab.restclients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 30/01/2016 at 13:27.
 */
@Component
public class APIEngineClient extends AbstractClient {

    @Autowired
    public APIEngineClient(@Value("${APIEngineURL}") String URL, RestTemplate restTemplate) {
        this.URL = URL;
        this.restTemplate = restTemplate;
    }
}
