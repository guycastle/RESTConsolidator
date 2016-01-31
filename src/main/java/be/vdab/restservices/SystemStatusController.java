package be.vdab.restservices;

import be.vdab.exceptions.NoRESTClientPropertiesFoundException;
import be.vdab.exceptions.NoSystemStatusFoundException;
import be.vdab.restclients.CreateRESTClientBeans;
import be.vdab.restclients.SystemStatusClient;
import be.vdab.valueobjects.SystemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created on 30/01/2016 at 14:24.
 */
@RestController
@RequestMapping(path = "/system", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
@ExposesResourceFor(SystemStatus.class)
class SystemStatusController {
    private final List<SystemStatusClient> clients;
    private final EntityLinks entityLinks;

    @Autowired
    public SystemStatusController(@Qualifier("URLProperties") Properties URLs, @SuppressWarnings("SpringJavaAutowiringInspection") EntityLinks entityLinks) {
        this.entityLinks = entityLinks;
        this.clients = new ArrayList<>();
        ApplicationContext context = new AnnotationConfigApplicationContext(CreateRESTClientBeans.class);
        URLs.values().forEach(url -> clients.add(context.getBean(SystemStatusClient.class).setURL((String) url)));

    }

    @RequestMapping(method = RequestMethod.GET)
    SystemStatusesResource getStatuses() {
        return new SystemStatusesResource(getAll(), entityLinks);
    }

    private Iterable<SystemStatus> getAll() {
        List<SystemStatus> returnValue = new ArrayList<>();
        clients.forEach(client -> returnValue.add(client.getSystemStatus()));
        return returnValue;
    }

    @ExceptionHandler(NoSystemStatusFoundException.class)
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    void getFailed() {
    }

    @ExceptionHandler(NoRESTClientPropertiesFoundException.class)
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    void couldNotFindProperties() {
    }
}
