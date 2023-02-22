package com.surtiviveres.empleados.values.id;

import com.surtiviveres.empleados.generic.Identity;

public class EncargadoCajaId extends Identity {

    public EncargadoCajaId() {
    }

    public EncargadoCajaId(String uuid) {
        super(uuid);
    }

    public static EncargadoCajaId of(String uuid) {
        return new EncargadoCajaId(uuid);
    }

}
