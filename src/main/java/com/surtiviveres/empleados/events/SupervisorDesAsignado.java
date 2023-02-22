package com.surtiviveres.empleados.events;

import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.domain.AsesorDeVentas;
import com.surtiviveres.empleados.domain.EncargadoCaja;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.SupervisorId;

public class SupervisorDesAsignado extends DomainEvent {
    private SupervisorId supervisorId;
    private Nombres nombres;
    private Apellidos apellidos;
    private FechaIngreso fechaIngreso;
    private Set<EncargadoCaja> cajerosAcargo;
    private Set<AsesorDeVentas> asesoresDeVentaAcargo;

    public SupervisorDesAsignado(SupervisorId supervisorId, Nombres nombres, Apellidos apellidos,
            FechaIngreso fechaIngreso) {
        super("empleados.supervisordesasignado");
        this.supervisorId = supervisorId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.cajerosAcargo = new HashSet<>();
        this.asesoresDeVentaAcargo = new HashSet<>();
    }

    public SupervisorId getSupervisorId() {
        return supervisorId;
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

    public Set<EncargadoCaja> getCajerosAcargo() {
        return cajerosAcargo;
    }

    public Set<AsesorDeVentas> getAsesoresDeVentaAcargo() {
        return asesoresDeVentaAcargo;
    }
}