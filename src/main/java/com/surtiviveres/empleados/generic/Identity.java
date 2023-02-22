package com.surtiviveres.empleados.generic;

import java.util.UUID;

public class Identity implements ValueObject<String> {
    private final String uuid;

    public Identity() {
        this.uuid = UUID.randomUUID().toString();
    }

    public Identity(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String value() {
        return uuid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Identity other = (Identity) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

}
