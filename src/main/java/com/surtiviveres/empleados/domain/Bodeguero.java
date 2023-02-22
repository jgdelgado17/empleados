package com.surtiviveres.empleados.domain;

import com.surtiviveres.empleados.generic.Entity;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Horario;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.BodegueroId;

public class Bodeguero extends Entity<BodegueroId> {
    private Nombres nombres;
    private Apellidos apellidos;
    private FechaIngreso fechaIngreso;
    private Horario horario;

    public Bodeguero(BodegueroId bodegueroId, Nombres nombres, Apellidos apellidos, FechaIngreso fechaIngreso,
            Horario horario) {
        super(bodegueroId);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.horario = horario;
    }

    public void modificarnombreBodeguero(Nombres nombres) {
        this.nombres = nombres;
    }

    public void modificarApellidoBodeguero(Apellidos apellidos) {
        this.apellidos = apellidos;
    }

    public void modificarFechaIngresoBodeguero(FechaIngreso fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void modificarHorarioBodeguero(Horario horario) {
        this.horario = horario;
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

    public Horario horario() {
        return horario;
    }
}
