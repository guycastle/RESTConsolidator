package be.vdab.restservices;

import be.vdab.valueobjects.SystemStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ResourceSupport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 30/01/2016 at 14:37.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class SystemStatusesResource extends ResourceSupport {

    @XmlElement(name = "SystemStatus")
    @JsonProperty("SystemStatus")
    private List<SystemStatus> systemStatuses = new ArrayList<>();

    SystemStatusesResource() {
    }

    SystemStatusesResource(Iterable<SystemStatus> systemStatuses, EntityLinks entityLinks) {
        systemStatuses.forEach(systemStatus -> {
            this.systemStatuses.add(systemStatus);
            this.add(entityLinks.linkToSingleResource(SystemStatus.class, systemStatus.getId())
                    .withRel("SystemId:" + systemStatus.getId()));
        });
        this.add(entityLinks.linkToCollectionResource(SystemStatus.class));
    }
}
