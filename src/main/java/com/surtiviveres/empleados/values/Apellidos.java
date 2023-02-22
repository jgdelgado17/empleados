package com.surtiviveres.empleados.values;

import java.util.Objects;

import com.surtiviveres.empleados.generic.ValueObject;

public class Apellidos implements ValueObject<String> {
    private final String apellidos;
    private final int longitud = 50;

    public Apellidos(String apellidos) {
        this.apellidos = Objects.requireNonNull(apellidos);
        
        if (this.apellidos.isEmpty() || this.apellidos.length() > longitud) {
            throw new IllegalArgumentException("El apellido no es valido");
        }
    }

    @Override
    public String value() {
        return apellidos;
    }

}
