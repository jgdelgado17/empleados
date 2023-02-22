package com.surtiviveres.empleados.values.id;

import com.surtiviveres.empleados.generic.Identity;

public class AsesorDeVentasId extends Identity {

    public AsesorDeVentasId() {
    }

    public AsesorDeVentasId(String uuid) {
        super(uuid);
    }

    public static AsesorDeVentasId of(String uuid) {
        return new AsesorDeVentasId(uuid);
    }
    
}
