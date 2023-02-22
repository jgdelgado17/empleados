package com.surtiviveres.empleados.values;

import java.util.Objects;

import com.surtiviveres.empleados.generic.ValueObject;

public class Nombres implements ValueObject<String> {
    private final String nombres;
    private final int longitud = 50;

    public Nombres(String nombres) {
        this.nombres = Objects.requireNonNull(nombres);
        
        if (this.nombres.isEmpty() || this.nombres.length() > longitud) {
            throw new IllegalArgumentException("El nombre no es valido");
        }
    }

    @Override
    public String value() {
        return nombres;
    }
}
