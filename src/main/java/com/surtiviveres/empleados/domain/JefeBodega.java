package com.surtiviveres.empleados.domain;

import java.util.HashSet;
import java.util.Set;

import com.surtiviveres.empleados.generic.Entity;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.JefeBodegaId;

public class JefeBodega extends Entity<JefeBodegaId> {
    private Nombres nombres;
    private Apellidos apellidos;
    private FechaIngreso fechaIngreso;
    private Set<Bodeguero> bodeguerosAcargo;

    public JefeBodega(JefeBodegaId jefeBodegaId, Nombres nombres, Apellidos apellidos, FechaIngreso fechaIngreso) {
        super(jefeBodegaId);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.bodeguerosAcargo = new HashSet<>();
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

    public void asignarBodeguero(Bodeguero nuevoBodeguero) {
        this.bodeguerosAcargo.add(nuevoBodeguero);
    }

    public void desAsignarBodeguero(Bodeguero bodeguero) {
        this.bodeguerosAcargo.remove(bodeguero);
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
}
