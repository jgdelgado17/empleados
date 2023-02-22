package com.surtiviveres.empleados.events;

import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Horario;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.EncargadoCajaId;
import com.surtiviveres.empleados.values.id.SupervisorId;

public class CajeroDesAsignadoAsupervisor extends DomainEvent {
    private EncargadoCajaId encargadoCajaId;
    private Nombres nombres;
    private Apellidos apellidos;
    private FechaIngreso fechaIngreso;
    private Horario horario;
    private SupervisorId supervisorId;

    public CajeroDesAsignadoAsupervisor(EncargadoCajaId encargadoCajaId, Nombres nombres,
            Apellidos apellidos, FechaIngreso fechaIngreso, Horario horario, SupervisorId supervisorId) {
        super("empleados.cajerodesasignadoasupervisor");
        this.encargadoCajaId = encargadoCajaId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.horario = horario;
        this.supervisorId = supervisorId;
    }

    public EncargadoCajaId getEncargadoCajaId() {
        return encargadoCajaId;
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

    public SupervisorId getSupervisorId() {
        return supervisorId;
    }
}
