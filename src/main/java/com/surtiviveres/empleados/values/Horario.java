package com.surtiviveres.empleados.values;

import java.util.Objects;

import com.surtiviveres.empleados.generic.ValueObject;

public class Horario implements ValueObject<Horario.Props> {
    private final int horaInicio;
    private final int horaFin;

    public Horario(int inicio, int fin) {
        this.horaInicio = Objects.requireNonNull(inicio);
        this.horaFin = Objects.requireNonNull(fin);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public int horaInicio() {
                return horaInicio;
            }

            @Override
            public int horaFin() {
                return horaFin;
            }

        };
    }

    public interface Props {
        int horaInicio();
        int horaFin();
    }
}
