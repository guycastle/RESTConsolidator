package be.vdab.restservices;

import be.vdab.valueobjects.SystemStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 30/01/2016 at 14:37.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SystemStatusesResource {
    private List<SystemStatus> systemStatuses = new ArrayList<SystemStatus>();

    public void addSystemStatus(SystemStatus systemStatus) {
        systemStatuses.add(systemStatus);
    }

    public List<SystemStatus> getSystemStatuses() {
        return systemStatuses;
    }
}
