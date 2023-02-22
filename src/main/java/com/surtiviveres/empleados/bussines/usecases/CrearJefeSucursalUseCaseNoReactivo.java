package com.surtiviveres.empleados.bussines.usecases;

import java.util.List;
import java.util.stream.Collectors;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.bussines.generic.UseCaseForCommandNoReactive;
import com.surtiviveres.empleados.command.CrearJefeSucursalCommand;
import com.surtiviveres.empleados.domain.JefeSucursal;
import com.surtiviveres.empleados.generic.Command;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.JefeSucursalId;

public class CrearJefeSucursalUseCaseNoReactivo implements UseCaseForCommandNoReactive {

    private Repository repository;

    public CrearJefeSucursalUseCaseNoReactivo(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(Command command) {

        CrearJefeSucursalCommand crearJefeSucursal = (CrearJefeSucursalCommand) command;

        JefeSucursal jefeSucursal = new JefeSucursal(
                JefeSucursalId.of(crearJefeSucursal.getJefeSucursalId()),
                new Nombres(crearJefeSucursal.getNombres()),
                new Apellidos(crearJefeSucursal.getApellidos()),
                new FechaIngreso(crearJefeSucursal.getFechaIngreso()));

        return jefeSucursal.getUncommittedChanges().stream().map(event -> {
            return repository.saveEventNoReactivo(event);
        }).collect(Collectors.toList());
    }

}
