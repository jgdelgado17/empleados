package com.surtiviveres.empleados.domain;

import com.surtiviveres.empleados.generic.Entity;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Horario;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.AsesorDeVentasId;

public class AsesorDeVentas extends Entity<AsesorDeVentasId> {
    private Nombres nombres;
    private Apellidos apellidos;
    private FechaIngreso fechaIngreso;
    private Horario horario;

    public AsesorDeVentas(AsesorDeVentasId asesorDeVentasId, Nombres nombres, Apellidos apellidos,
            FechaIngreso fechaIngreso, Horario horario) {
        super(asesorDeVentasId);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.horario = horario;
    }

    public void modificarnombreAsesorDeVentas(Nombres nombres) {
        this.nombres = nombres;
    }

    public void modificarApellidoAsesorDeVentas(Apellidos apellidos) {
        this.apellidos = apellidos;
    }

    public void modificarFechaIngresoAsesorDeventas(FechaIngreso fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void modificarHorarioAsesorVentas(Horario horario) {
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
