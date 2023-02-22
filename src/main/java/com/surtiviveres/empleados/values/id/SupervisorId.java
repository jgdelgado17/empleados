package com.surtiviveres.empleados.values.id;

import com.surtiviveres.empleados.generic.Identity;

public class SupervisorId extends Identity {

    public SupervisorId() {
    }

    public SupervisorId(String uuid) {
        super(uuid);
    }

    public static SupervisorId of(String uuid) {
        return new SupervisorId(uuid);
    }

}
