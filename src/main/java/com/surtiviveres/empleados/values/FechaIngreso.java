package com.surtiviveres.empleados.values;

import java.util.Date;
import java.util.Objects;

import com.surtiviveres.empleados.generic.ValueObject;

public class FechaIngreso implements ValueObject<Date> {
    private final Date fechaIngreso;

    public FechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = Objects.requireNonNull(fechaIngreso);
    }

    @Override
    public Date value() {
        return fechaIngreso;
    }

}
