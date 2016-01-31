package be.vdab.valueobjects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created on 30/01/2016 at 13:41.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SystemStatus {
    private String id;
    private String name;
    private String description;
    private String moreInfo;
    private String version;
    private String seafileVersion;
    private String environment;
    private String builtOn;
    private boolean up;

    public SystemStatus() {
    }

    public SystemStatus(String id, String name, String description, String moreInfo, String version, String seafileVersion, String environment, String builtOn, boolean up) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.moreInfo = moreInfo;
        this.version = version;
        this.seafileVersion = seafileVersion;
        this.environment = environment;
        this.builtOn = builtOn;
        this.up = up;
    }

    public SystemStatus(String id, String name, String description, String moreInfo, String version, String environment, String builtOn, boolean up) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.moreInfo = moreInfo;
        this.version = version;
        this.environment = environment;
        this.builtOn = builtOn;
        this.up = up;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public String getVersion() {
        return version;
    }

    public String getSeafileVersion() {
        return seafileVersion;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getBuiltOn() {
        return builtOn;
    }

    public boolean isUp() {
        return up;
    }
}
