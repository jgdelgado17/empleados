package com.surtiviveres.empleados.events;

import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Horario;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.BodegueroId;
import com.surtiviveres.empleados.values.id.JefeBodegaId;

public class BodegueroAsignadoAjefeBodega extends DomainEvent {
    private BodegueroId bodegueroId;
    private Nombres nombres;
    private Apellidos apellidos;
    private FechaIngreso fechaIngreso;
    private Horario horario;
    private JefeBodegaId jefeBodegaId;

    public BodegueroAsignadoAjefeBodega(BodegueroId bodegueroId, Nombres nombres, Apellidos apellidos,
            FechaIngreso fechaIngreso, Horario horario, JefeBodegaId jefeBodegaId) {
        super("empleados.bodegueroasignadoajefebodega");
        this.bodegueroId = bodegueroId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.horario = horario;
        this.jefeBodegaId = jefeBodegaId;
    }

    public BodegueroId getBodegueroId() {
        return bodegueroId;
    }

    public Nombres getNombres() {
        return nombres;
    }

    public Apellidos getApellidos() {
        return apellidos;
    }

    public FechaIngreso getFechaIngreso() {
        return fechaIngreso;
    }

    public Horario getHorario() {
        return horario;
    }

    public JefeBodegaId getJefeBodegaId() {
        return jefeBodegaId;
    }
}
