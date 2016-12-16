package org.citopt.sensmonqtt.domain.component;

import java.util.Objects;
import javax.persistence.GeneratedValue;
import org.bson.types.ObjectId;
import org.citopt.sensmonqtt.domain.device.Device;
import org.citopt.sensmonqtt.domain.type.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author rafaelkperes
 */
@Document
public class Component {
    
    public enum Specie {
        SENSOR, ACTUATOR
    }
    
    @Id
    @GeneratedValue
    private ObjectId id;

    @Indexed(unique = true)
    private String name;
    private Specie specie;
    
    @Reference
    private Type type;
    
    @Reference
    private Device device;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Component other = (Component) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Component{" + "id=" + id + ", name=" + name + ", type=" + type + '}';
    }

}