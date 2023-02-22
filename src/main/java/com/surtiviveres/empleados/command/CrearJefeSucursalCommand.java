package com.surtiviveres.empleados.command;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.domain.JefeBodega;
import com.surtiviveres.empleados.domain.Supervisor;
import com.surtiviveres.empleados.generic.Command;

public class CrearJefeSucursalCommand extends Command {
    private String jefeSucursalId;
    private String nombres;
    private String apellidos;
    private Date fechaIngreso;
    private Set<Supervisor> supervisoresAcargo;
    private Set<JefeBodega> jefesBodegaAcargo;

    public CrearJefeSucursalCommand() {
        this.supervisoresAcargo = new HashSet<>();
        this.jefesBodegaAcargo = new HashSet<>();
    }

    public CrearJefeSucursalCommand(String jefeSucursalId, String nombres, String apellidos, Date fechaIngreso) {
        this.jefeSucursalId = jefeSucursalId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.supervisoresAcargo = new HashSet<>();
        this.jefesBodegaAcargo = new HashSet<>();
    }

    public String getJefeSucursalId() {
        return jefeSucursalId;
    }

    public void setJefeSucursalId(String jefeSucursalId) {
        this.jefeSucursalId = jefeSucursalId;
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

    public Set<Supervisor> getSupervisoresAcargo() {
        return supervisoresAcargo;
    }

    public void setSupervisoresAcargo(Set<Supervisor> supervisoresAcargo) {
        this.supervisoresAcargo = supervisoresAcargo;
    }

    public Set<JefeBodega> getJefesBodegaAcargo() {
        return jefesBodegaAcargo;
    }

    public void setJefesBodegaAcargo(Set<JefeBodega> jefesBodegaAcargo) {
        this.jefesBodegaAcargo = jefesBodegaAcargo;
    }
}
