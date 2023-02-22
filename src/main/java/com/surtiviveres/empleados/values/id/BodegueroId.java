package com.surtiviveres.empleados.values.id;

import com.surtiviveres.empleados.generic.Identity;

public class BodegueroId extends Identity {

    public BodegueroId() {
    }

    public BodegueroId(String uuid) {
        super(uuid);
    }

    public static BodegueroId of(String uuid) {
        return new BodegueroId(uuid);
    }
    
}
