package be.vdab.restclients;

import be.vdab.exceptions.NoSystemStatusFoundException;
import be.vdab.valueobjects.SystemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 31/01/2016 at 13:23.
 */
@Component
@Scope("prototype")
class SystemStatusClientImpl implements SystemStatusClient {
    private final RestTemplate restTemplate;
    private String URL;


    @Autowired
    public SystemStatusClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SystemStatusClient setURL(String URL) {
        this.URL = URL;
        return this;
    }

    @Override
    public SystemStatus getSystemStatus() {
        try {
            return restTemplate.getForObject(URL, SystemStatus.class);
        } catch (Exception ex) {
            throw new NoSystemStatusFoundException();
        }
    }
}
