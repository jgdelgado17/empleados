package com.surtiviveres.empleados.domain;

import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.generic.Entity;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.SupervisorId;

public class Supervisor extends Entity<SupervisorId> {
    private Nombres nombres;
    private Apellidos apellidos;
    private FechaIngreso fechaIngreso;
    private Set<EncargadoCaja> cajerosAcargo;
    private Set<AsesorDeVentas> asesoresDeVentaAcargo;

    public Supervisor(SupervisorId supervisorId, Nombres nombres, Apellidos apellidos, FechaIngreso fechaIngreso) {
        super(supervisorId);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.cajerosAcargo = new HashSet<>();
        this.asesoresDeVentaAcargo = new HashSet<>();
    }

    public void modificarNombreSupervisor(Nombres nombres) {
        this.nombres = nombres;
    }

    public void modificarApellidoSupervisor(Apellidos apellidos) {
        this.apellidos = apellidos;
    }

    public void modificarFechaIngresoSuperivisor(FechaIngreso fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void asignarCajero(EncargadoCaja nuevoCajero) {
        this.cajerosAcargo.add(nuevoCajero);
    }

    public void asignarAsesor(AsesorDeVentas nuevoAsesor) {
        this.asesoresDeVentaAcargo.add(nuevoAsesor);
    }

    public void desAsignarCajero(EncargadoCaja cajero) {
        this.cajerosAcargo.remove(cajero);
    }

    public void desAsignarAsesor(AsesorDeVentas asesor) {
        this.asesoresDeVentaAcargo.remove(asesor);
    }

    public Nombres nombres() {
        return nombres;
    }

    public Apellidos apellidos() {
        return apellidos;
    }

    public FechaIngreso fechaIngreso() {
        return fechaIngreso;
    }

    public Set<EncargadoCaja> cajerosAcargo() {
        return cajerosAcargo;
    }

    public Set<AsesorDeVentas> asesoresDeVentaAcargo() {
        return asesoresDeVentaAcargo;
    }

}
