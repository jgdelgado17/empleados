package com.surtiviveres.empleados.bussines.usecases;

import java.util.List;
import java.util.stream.Collectors;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.bussines.generic.UseCaseForCommandNoReactive;
import com.surtiviveres.empleados.command.AsignarAsesorVentasAsupervisorCommand;
import com.surtiviveres.empleados.domain.JefeSucursal;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Horario;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.AsesorDeVentasId;
import com.surtiviveres.empleados.values.id.JefeSucursalId;
import com.surtiviveres.empleados.values.id.SupervisorId;

public class AsignarAsesorVentasAsupervisorUseCase
        implements UseCaseForCommandNoReactive<AsignarAsesorVentasAsupervisorCommand> {

    private Repository repository;

    public AsignarAsesorVentasAsupervisorUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AsignarAsesorVentasAsupervisorCommand command) {

        List<DomainEvent> events = repository.findByIdNoReactivo(command.getJefeSucursalId());

        JefeSucursal jefeSucursal = JefeSucursal.from(JefeSucursalId.of(command.getJefeSucursalId()), events);

        jefeSucursal.asignarAsesorVentasAsupervisor(SupervisorId.of(command.getSupervisorId()),
                AsesorDeVentasId.of(command.getAsesorVentasId()),
                new Nombres(command.getNombres()),
                new Apellidos(command.getApellidos()),
                new FechaIngreso(command.getFechaIngreso()),
                new Horario(command.getHorarioInicio(), command.getHorarioFin()));

        return jefeSucursal.getUncommittedChanges().stream().map(event -> {
            return repository.saveEventNoReactivo(event);
        }).collect(Collectors.toList());
    }

}
