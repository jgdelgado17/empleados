package com.surtiviveres.empleados.command;

import java.util.Date;

import com.surtiviveres.empleados.generic.Command;

public class AsignarBodegueroAjefeBodegaCommand extends Command {
    private String jefeSucursalId;
    private String jefeBodegaId;
    private String bodegueroId;
    private String nombres;
    private String apellidos;
    private Date fechaIngreso;
    private int horarioInicio;
    private int horarioFin;

    public AsignarBodegueroAjefeBodegaCommand() {
    }

    public AsignarBodegueroAjefeBodegaCommand(String jefeSucursalId, String jefeBodegaId, String bodegueroId,
            String nombres, String apellidos, Date fechaIngreso, int horarioInicio, int horarioFin) {
        this.jefeSucursalId = jefeSucursalId;
        this.jefeBodegaId = jefeBodegaId;
        this.bodegueroId = bodegueroId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
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

    public String getBodegueroId() {
        return bodegueroId;
    }

    public void setBodegueroId(String bodegueroId) {
        this.bodegueroId = bodegueroId;
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

    public int getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(int horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public int getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(int horarioFin) {
        this.horarioFin = horarioFin;
    }
}
