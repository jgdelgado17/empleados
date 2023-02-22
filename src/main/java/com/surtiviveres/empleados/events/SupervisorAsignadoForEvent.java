package com.surtiviveres.empleados.events;

import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.domain.AsesorDeVentas;
import com.surtiviveres.empleados.domain.EncargadoCaja;
import com.surtiviveres.empleados.domain.JefeBodega;
import com.surtiviveres.empleados.domain.Supervisor;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.SupervisorId;

public class SupervisorAsignadoForEvent extends DomainEvent {
    private Nombres nombresJefeSucu;
    private Apellidos apellidosJefeSucu;
    private FechaIngreso fechaIngresoJefeSucu;
    private Set<Supervisor> supervisoresAcargoJefeSucu;
    private Set<JefeBodega> jefesBodegaAcargoJefeSucu;

    private SupervisorId supervisorId;
    private Nombres nombresSupervisor;
    private Apellidos apellidosSupervisor;
    private FechaIngreso fechaIngresoSupervisor;
    private Set<EncargadoCaja> cajerosAcargoSupervisor;
    private Set<AsesorDeVentas> asesoresDeVentaAcargoSupervisor;

    public SupervisorAsignadoForEvent(Nombres nombresJefeSucu, Apellidos apellidosJefeSucu,
            FechaIngreso fechaIngresoJefeSucu,
            SupervisorId supervisorId, Nombres nombresSupervisor, Apellidos apellidosSupervisor,
            FechaIngreso fechaIngresoSupervisor) {
        super("empleados.supervisorasignadoforevent");
        // super("empleados.supervisorasignado");
        this.nombresJefeSucu = nombresJefeSucu;
        this.apellidosJefeSucu = apellidosJefeSucu;
        this.fechaIngresoJefeSucu = fechaIngresoJefeSucu;
        this.supervisoresAcargoJefeSucu = new HashSet<>();
        this.jefesBodegaAcargoJefeSucu = new HashSet<>();
        this.supervisorId = supervisorId;
        this.nombresSupervisor = nombresSupervisor;
        this.apellidosSupervisor = apellidosSupervisor;
        this.fechaIngresoSupervisor = fechaIngresoSupervisor;
        this.cajerosAcargoSupervisor = new HashSet<>();
        this.asesoresDeVentaAcargoSupervisor = new HashSet<>();
    }

    public Nombres getNombresJefeSucu() {
        return nombresJefeSucu;
    }

    public Apellidos getApellidosJefeSucu() {
        return apellidosJefeSucu;
    }

    public FechaIngreso getFechaIngresoJefeSucu() {
        return fechaIngresoJefeSucu;
    }

    public Set<Supervisor> getSupervisoresAcargoJefeSucu() {
        return supervisoresAcargoJefeSucu;
    }

    public Set<JefeBodega> getJefesBodegaAcargoJefeSucu() {
        return jefesBodegaAcargoJefeSucu;
    }

    public SupervisorId getSupervisorId() {
        return supervisorId;
    }

    public Nombres getNombresSupervisor() {
        return nombresSupervisor;
    }

    public Apellidos getApellidosSupervisor() {
        return apellidosSupervisor;
    }

    public FechaIngreso getFechaIngresoSupervisor() {
        return fechaIngresoSupervisor;
    }

    public Set<EncargadoCaja> getCajerosAcargoSupervisor() {
        return cajerosAcargoSupervisor;
    }

    public Set<AsesorDeVentas> getAsesoresDeVentaAcargoSupervisor() {
        return asesoresDeVentaAcargoSupervisor;
    }
}
