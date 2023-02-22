package com.surtiviveres.empleados.bussines.usecases;

import java.util.List;
import java.util.stream.Collectors;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.bussines.generic.UseCaseForCommandNoReactive;
import com.surtiviveres.empleados.command.AsignarSupervisorCommand;
import com.surtiviveres.empleados.domain.JefeSucursal;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.JefeSucursalId;
import com.surtiviveres.empleados.values.id.SupervisorId;

public class AsignarSupervisorUseCase implements UseCaseForCommandNoReactive<AsignarSupervisorCommand> {

    private Repository repository;

    public AsignarSupervisorUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AsignarSupervisorCommand command) {

        List<DomainEvent> events = repository.findByIdNoReactivo(command.getJefeSucursalId());

        JefeSucursal jefeSucursal = JefeSucursal.from(
                JefeSucursalId.of(command.getJefeSucursalId()),
                events);

        jefeSucursal.asignarSupervisor(SupervisorId.of(command.getSupervisorId()),
                new Nombres(command.getNombres()),
                new Apellidos(command.getApellidos()),
                new FechaIngreso(command.getFechaIngreso()));

        return jefeSucursal.getUncommittedChanges().stream().map(event -> {
            return repository.saveEventNoReactivo(event);
        }).collect(Collectors.toList());
    }

}
