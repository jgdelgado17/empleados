package com.surtiviveres.empleados.command;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.domain.Bodeguero;
import com.surtiviveres.empleados.generic.Command;

public class AsignarJefeBodegaCommand extends Command {
    private String jefeSucursalId;
    private String jefeBodegaId;
    private String nombres;
    private String apellidos;
    private Date fechaIngreso;
    private Set<Bodeguero> bodeguerosAcargo;

    public AsignarJefeBodegaCommand() {
        this.bodeguerosAcargo = new HashSet<>();
    }

    public AsignarJefeBodegaCommand(String jefeSucursalId, String jefeBodegaId, String nombres, String apellidos,
            Date fechaIngreso) {
        this.jefeSucursalId = jefeSucursalId;
        this.jefeBodegaId = jefeBodegaId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.bodeguerosAcargo = new HashSet<>();
    }

    public String getJefeSucursalId() {
        return jefeSucursalId;
    }

    public void setJefeSucursalId(String jefeSucursalId) {
        this.jefeSucursalId = jefeSucursalId;
    }

    public String getJefeBodegaId() {
        return jefeBodegaId;
    }

    public void setJefeBodegaId(String jefeBodegaId) {
        this.jefeBodegaId = jefeBodegaId;
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

    public Set<Bodeguero> getBodeguerosAcargo() {
        return bodeguerosAcargo;
    }

    public void setBodeguerosAcargo(Set<Bodeguero> bodeguerosAcargo) {
        this.bodeguerosAcargo = bodeguerosAcargo;
    }
}
