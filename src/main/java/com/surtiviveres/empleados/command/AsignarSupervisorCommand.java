package com.surtiviveres.empleados.command;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.domain.AsesorDeVentas;
import com.surtiviveres.empleados.domain.EncargadoCaja;
import com.surtiviveres.empleados.generic.Command;

public class AsignarSupervisorCommand extends Command{
    private String jefeSucursalId;
    private String supervisorId;
    private String nombres;
    private String apellidos;
    private Date fechaIngreso;
    private Set<EncargadoCaja> cajerosAcargo;
    private Set<AsesorDeVentas> asesoresDeVentaAcargo;

    public AsignarSupervisorCommand() {
        this.cajerosAcargo = new HashSet<>();
        this.asesoresDeVentaAcargo = new HashSet<>();
    }

    public AsignarSupervisorCommand(String jefeSucursalId, String supervisorId, String nombres, String apellidos,
            Date fechaIngreso) {
        this.jefeSucursalId = jefeSucursalId;
        this.supervisorId = supervisorId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.cajerosAcargo = new HashSet<>();
        this.asesoresDeVentaAcargo = new HashSet<>();
    }

    public String getJefeSucursalId() {
        return jefeSucursalId;
    }

    public void setJefeSucursalId(String jefeSucursalId) {
        this.jefeSucursalId = jefeSucursalId;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Set<EncargadoCaja> getCajerosAcargo() {
        return cajerosAcargo;
    }

    public void setCajerosAcargo(Set<EncargadoCaja> cajerosAcargo) {
        this.cajerosAcargo = cajerosAcargo;
    }

    public Set<AsesorDeVentas> getAsesoresDeVentaAcargo() {
        return asesoresDeVentaAcargo;
    }

    public void setAsesoresDeVentaAcargo(Set<AsesorDeVentas> asesoresDeVentaAcargo) {
        this.asesoresDeVentaAcargo = asesoresDeVentaAcargo;
    }
}
