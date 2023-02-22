package com.surtiviveres.empleados.command;

import java.util.Date;

import com.surtiviveres.empleados.generic.Command;

public class AsignarEncargadoCajaAsupervisorCommand extends Command {
    private String jefeSucursalId;
    private String supervisorId;
    private String encargadoCajaId;
    private String nombres;
    private String apellidos;
    private Date fechaIngreso;
    private int horarioInicio;
    private int horarioFin;

    public AsignarEncargadoCajaAsupervisorCommand() {
    }

    public AsignarEncargadoCajaAsupervisorCommand(String jefeSucursalId, String supervisorId, String encargadoCajaId,
            String nombres, String apellidos, Date fechaIngreso, int horarioInicio, int horarioFin) {
        this.jefeSucursalId = jefeSucursalId;
        this.supervisorId = supervisorId;
        this.encargadoCajaId = encargadoCajaId;
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

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getEncargadoCajaId() {
        return encargadoCajaId;
    }

    public void setEncargadoCajaId(String encargadoCajaId) {
        this.encargadoCajaId = encargadoCajaId;
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
