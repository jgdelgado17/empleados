package com.surtiviveres.empleados.domain;

import java.util.List;
import java.util.Set;

import com.surtiviveres.empleados.events.AsesorVentasAsignadoAsupervisor;
import com.surtiviveres.empleados.events.AsesorVentasDesAsignadoAsupervisor;
import com.surtiviveres.empleados.events.BodegueroAsignadoAjefeBodega;
import com.surtiviveres.empleados.events.BodegueroDesAsignadoAjefeBodega;
import com.surtiviveres.empleados.events.CajeroAsignadoAsupervisor;
import com.surtiviveres.empleados.events.CajeroDesAsignadoAsupervisor;
import com.surtiviveres.empleados.events.JefeBodegaAsignado;
import com.surtiviveres.empleados.events.JefeBodegaDesAsignado;
import com.surtiviveres.empleados.events.JefeSucursalCreado;
import com.surtiviveres.empleados.events.SupervisorAsignado;
import com.surtiviveres.empleados.events.SupervisorDesAsignado;
import com.surtiviveres.empleados.generic.AggregateRoot;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Horario;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.AsesorDeVentasId;
import com.surtiviveres.empleados.values.id.BodegueroId;
import com.surtiviveres.empleados.values.id.EncargadoCajaId;
import com.surtiviveres.empleados.values.id.JefeBodegaId;
import com.surtiviveres.empleados.values.id.JefeSucursalId;
import com.surtiviveres.empleados.values.id.SupervisorId;

public class JefeSucursal extends AggregateRoot<JefeSucursalId> {
    protected Nombres nombres;
    protected Apellidos apellidos;
    protected FechaIngreso fechaIngreso;
    protected Set<Supervisor> supervisoresAcargo;
    protected Set<JefeBodega> jefesBodegaAcargo;

    public JefeSucursal(JefeSucursalId jefeSucursalId, Nombres nombres, Apellidos apellidos,
            FechaIngreso fechaIngreso) {
        super(jefeSucursalId);
        subscribe(new JefeSucursalEventChange(this));
        appendChange(new JefeSucursalCreado(nombres, apellidos, fechaIngreso)).apply();
    }

    private JefeSucursal(JefeSucursalId id) {
        super(id);
        subscribe(
                new JefeSucursalEventChange(this));
    }

    public static JefeSucursal from(JefeSucursalId id, List<DomainEvent> events) {
        JefeSucursal jefeSucursal = new JefeSucursal(id);
        events.forEach(jefeSucursal::applyEvent);
        return jefeSucursal;
    }

    public void asignarSupervisor(SupervisorId supervisorId, Nombres nombres, Apellidos apellidos,
            FechaIngreso fechaIngreso) {
        appendChange(new SupervisorAsignado(supervisorId, nombres, apellidos, fechaIngreso)).apply();
    }

    public void desAsignarSupervisor(SupervisorId supervisorId, Nombres nombres, Apellidos apellidos,
            FechaIngreso fechaIngreso) {
        appendChange(new SupervisorDesAsignado(supervisorId, nombres, apellidos, fechaIngreso)).apply();
    }

    public void asignarJefeBodega(JefeBodegaId jefeBodegaId, Nombres nombres, Apellidos apellidos,
            FechaIngreso fechaIngreso) {
        appendChange(new JefeBodegaAsignado(jefeBodegaId, nombres, apellidos, fechaIngreso)).apply();
    }

    public void desAsignarJefeBodega(JefeBodegaId jefeBodegaId, Nombres nombres, Apellidos apellidos,
            FechaIngreso fechaIngreso) {
        appendChange(new JefeBodegaDesAsignado(jefeBodegaId, nombres, apellidos, fechaIngreso)).apply();
    }

    public void asignarCajeroAsupervisor(SupervisorId supervisorId, EncargadoCajaId encargadoCajaId, Nombres nombres,
            Apellidos apellidos, FechaIngreso fechaIngreso, Horario horario) {
        appendChange(
                new CajeroAsignadoAsupervisor(supervisorId, encargadoCajaId, nombres, apellidos, fechaIngreso, horario))
                .apply();
    }

    public void desAsignarCajeroAsupervisor(SupervisorId supervisorId, EncargadoCajaId encargadoCajaId, Nombres nombres,
            Apellidos apellidos, FechaIngreso fechaIngreso, Horario horario) {
        appendChange(new CajeroDesAsignadoAsupervisor(encargadoCajaId, nombres, apellidos, fechaIngreso, horario,
                supervisorId))
                .apply();
    }

    public void asignarAsesorVentasAsupervisor(SupervisorId supervisorId, AsesorDeVentasId encargadoCajaIdVentasId,
            Nombres nombres, Apellidos apellidos, FechaIngreso fechaIngreso, Horario horario) {
        appendChange(new AsesorVentasAsignadoAsupervisor(encargadoCajaIdVentasId, nombres, apellidos, fechaIngreso,
                horario, supervisorId)).apply();
    }

    public void desAsignarAsesorVentasAsupervisor(SupervisorId supervisorId, AsesorDeVentasId encargadoCajaIdVentasId,
            Nombres nombres, Apellidos apellidos, FechaIngreso fechaIngreso, Horario horario) {
        appendChange(new AsesorVentasDesAsignadoAsupervisor(encargadoCajaIdVentasId, nombres, apellidos, fechaIngreso,
                horario, supervisorId)).apply();
    }

    public void asignarBodegueroAjefeBodega(JefeBodegaId jefeBodegaId, BodegueroId bodegueroId,
            Nombres nombres, Apellidos apellidos, FechaIngreso fechaIngreso, Horario horario) {
        appendChange(
                new BodegueroAsignadoAjefeBodega(bodegueroId, nombres, apellidos, fechaIngreso, horario, jefeBodegaId))
                .apply();
    }

    public void desAsignarBodegueroAjefeBodega(JefeBodegaId jefeBodegaId, BodegueroId bodegueroId,
            Nombres nombres, Apellidos apellidos, FechaIngreso fechaIngreso, Horario horario) {
        appendChange(new BodegueroDesAsignadoAjefeBodega(bodegueroId, nombres, apellidos, fechaIngreso, horario,
                jefeBodegaId)).apply();
    }
}
