package be.vdab.restservices;

import be.vdab.restclients.APIEngineClient;
import be.vdab.restclients.DigitalVaultClient;
import be.vdab.restclients.SystemStatusClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 30/01/2016 at 14:24.
 */
@RestController
@RequestMapping(params = "/system")
public class SystemStatusController {
    private final List<SystemStatusClient> clients;

    @Autowired
    public SystemStatusController(APIEngineClient apiEngineClient, DigitalVaultClient digitalVaultClient) {
        clients = new ArrayList<SystemStatusClient>();
        clients.add(apiEngineClient);
        clients.add(digitalVaultClient);
    }

    @RequestMapping(method = RequestMethod.GET)
    String getStatuses() {
        return "hello";
    /*SystemStatusesResource getStatuses() {
        SystemStatusesResource systemStatusesResource = new SystemStatusesResource();
        clients.forEach(client -> systemStatusesResource.addSystemStatus(client.getSystemStatus()));
        return systemStatusesResource;*/
    }
}
