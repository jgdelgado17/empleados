package com.surtiviveres.empleados.command;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.domain.AsesorDeVentas;
import com.surtiviveres.empleados.domain.EncargadoCaja;
import com.surtiviveres.empleados.domain.JefeBodega;
import com.surtiviveres.empleados.domain.Supervisor;
import com.surtiviveres.empleados.generic.Command;

public class AsignarSupervisorForEventCommand extends Command {
    private String jefeSucursalId;
    private String nombresJefeSucu;
    private String apellidosJefeSucu;
    private Date fechaIngresoJefeSucu;
    private Set<Supervisor> supervisoresAcargoJefeSucu;
    private Set<JefeBodega> jefesBodegaAcargoJefeSucu;

    private String supervisorId;
    private String nombresSupervisor;
    private String apellidosSupervisor;
    private Date fechaIngresoSupervisor;
    private Set<EncargadoCaja> cajerosAcargoSupervisor;
    private Set<AsesorDeVentas> asesoresDeVentaAcargoSupervisor;

    public AsignarSupervisorForEventCommand() {
        this.supervisoresAcargoJefeSucu = new HashSet<>();
        this.jefesBodegaAcargoJefeSucu = new HashSet<>();
    }

    public AsignarSupervisorForEventCommand(String jefeSucursalId, String nombresJefeSucu, String apellidosJefeSucu,
            Date fechaIngresoJefeSucu) {
        this.jefeSucursalId = jefeSucursalId;
        this.nombresJefeSucu = nombresJefeSucu;
        this.apellidosJefeSucu = apellidosJefeSucu;
        this.fechaIngresoJefeSucu = fechaIngresoJefeSucu;
        this.supervisoresAcargoJefeSucu = new HashSet<>();
        this.jefesBodegaAcargoJefeSucu = new HashSet<>();
    }

    public String getJefeSucursalId() {
        return jefeSucursalId;
    }

    public void setJefeSucursalId(String jefeSucursalId) {
        this.jefeSucursalId = jefeSucursalId;
    }

    public String getNombresJefeSucu() {
        return nombresJefeSucu;
    }

    public void setNombresJefeSucu(String nombresJefeSucu) {
        this.nombresJefeSucu = nombresJefeSucu;
    }

    public String getApellidosJefeSucu() {
        return apellidosJefeSucu;
    }

    public void setApellidosJefeSucu(String apellidosJefeSucu) {
        this.apellidosJefeSucu = apellidosJefeSucu;
    }

    public Date getFechaIngresoJefeSucu() {
        return fechaIngresoJefeSucu;
    }

    public void setFechaIngresoJefeSucu(Date fechaIngresoJefeSucu) {
        this.fechaIngresoJefeSucu = fechaIngresoJefeSucu;
    }

    public Set<Supervisor> getSupervisoresAcargoJefeSucu() {
        return supervisoresAcargoJefeSucu;
    }

    public void setSupervisoresAcargoJefeSucu(Set<Supervisor> supervisoresAcargo) {
        this.supervisoresAcargoJefeSucu = supervisoresAcargo;
    }

    public Set<JefeBodega> getJefesBodegaAcargoJefeSucu() {
        return jefesBodegaAcargoJefeSucu;
    }

    public void setJefesBodegaAcargoJefeSucu(Set<JefeBodega> jefesBodegaAcargo) {
        this.jefesBodegaAcargoJefeSucu = jefesBodegaAcargo;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getNombresSupervisor() {
        return nombresSupervisor;
    }

    public void setNombresSupervisor(String nombresSupervisor) {
        this.nombresSupervisor = nombresSupervisor;
    }

    public String getApellidosSupervisor() {
        return apellidosSupervisor;
    }

    public void setApellidosSupervisor(String apellidosSupervisor) {
        this.apellidosSupervisor = apellidosSupervisor;
    }

    public Date getFechaIngresoSupervisor() {
        return fechaIngresoSupervisor;
    }

    public void setFechaIngresoSupervisor(Date fechaIngresoSupervisor) {
        this.fechaIngresoSupervisor = fechaIngresoSupervisor;
    }

    public Set<EncargadoCaja> getCajerosAcargoSupervisor() {
        return cajerosAcargoSupervisor;
    }

    public void setCajerosAcargoSupervisor(Set<EncargadoCaja> cajerosAcargoSupervisor) {
        this.cajerosAcargoSupervisor = cajerosAcargoSupervisor;
    }

    public Set<AsesorDeVentas> getAsesoresDeVentaAcargoSupervisor() {
        return asesoresDeVentaAcargoSupervisor;
    }

    public void setAsesoresDeVentaAcargoSupervisor(Set<AsesorDeVentas> asesoresDeVentaAcargoSupervisor) {
        this.asesoresDeVentaAcargoSupervisor = asesoresDeVentaAcargoSupervisor;
    }
}
