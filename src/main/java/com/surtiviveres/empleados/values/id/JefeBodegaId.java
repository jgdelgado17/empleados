package com.surtiviveres.empleados.values.id;

import com.surtiviveres.empleados.generic.Identity;

public class JefeBodegaId extends Identity {

    public JefeBodegaId() {
    }

    public JefeBodegaId(String uuid) {
        super(uuid);
    }

    public static JefeBodegaId of(String uuid) {
        return new JefeBodegaId(uuid);
    }
    
}
