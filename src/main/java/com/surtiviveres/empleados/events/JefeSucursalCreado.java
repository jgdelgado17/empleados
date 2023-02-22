package com.surtiviveres.empleados.events;

import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.domain.JefeBodega;
import com.surtiviveres.empleados.domain.Supervisor;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;

public class JefeSucursalCreado extends DomainEvent {
    private Nombres nombres;
    private Apellidos apellidos;
    private FechaIngreso fechaIngreso;
    private Set<Supervisor> supervisoresAcargo;
    private Set<JefeBodega> jefesBodegaAcargo;

    public JefeSucursalCreado(Nombres nombres, Apellidos apellidos, FechaIngreso fechaIngreso) {
        super("empleados.jefesucursalcreado");
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.supervisoresAcargo = new HashSet<>();
        this.jefesBodegaAcargo = new HashSet<>();
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

    public Set<Supervisor> getSupervisoresAcargo() {
        return supervisoresAcargo;
    }

    public Set<JefeBodega> getJefesBodegaAcargo() {
        return jefesBodegaAcargo;
    }

}
