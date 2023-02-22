package com.surtiviveres.empleados.events;

import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.domain.Bodeguero;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.JefeBodegaId;

public class JefeBodegaDesAsignado extends DomainEvent {
    private JefeBodegaId jefeBodegaId;
    private Nombres nombres;
    private Apellidos apellidos;
    private FechaIngreso fechaIngreso;
    private Set<Bodeguero> bodeguerosAcargo;

    public JefeBodegaDesAsignado(JefeBodegaId jefeBodegaId, Nombres nombres, Apellidos apellidos,
            FechaIngreso fechaIngreso) {
        super("empleados.jefebodegadesasignado");
        this.jefeBodegaId = jefeBodegaId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.bodeguerosAcargo = new HashSet<>();
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

    public JefeBodegaId getJefeBodegaId() {
        return jefeBodegaId;
    }

    public Set<Bodeguero> getBodeguerosAcargo() {
        return bodeguerosAcargo;
    }
}
