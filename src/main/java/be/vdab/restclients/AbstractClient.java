package be.vdab.restclients;

import be.vdab.exceptions.NoSystemStatusFoundException;
import be.vdab.valueobjects.SystemStatus;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 30/01/2016 at 14:07.
 */
abstract class AbstractClient implements SystemStatusClient {
    protected RestTemplate restTemplate;
    protected String URL;

    @Override
    public SystemStatus getSystemStatus() {
        try {
            return restTemplate.getForObject(URL, SystemStatus.class);
        } catch (Exception ex) {
            throw new NoSystemStatusFoundException();
        }
    }
}
