package com.surtiviveres.empleados.values.id;

import com.surtiviveres.empleados.generic.Identity;

public class JefeSucursalId extends Identity {

    public JefeSucursalId() {
    }

    public JefeSucursalId(String uuid) {
        super(uuid);
    }

    public static JefeSucursalId of(String uuid) {
        return new JefeSucursalId(uuid);
    }
    
}
