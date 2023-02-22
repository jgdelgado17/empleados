package com.surtiviveres.empleados.bussines.usecases;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.domain.JefeSucursal;
import com.surtiviveres.empleados.events.SupervisorAsignadoForEvent;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.id.JefeSucursalId;

public class AsignarSupervisorEventUseCaseNoReactivo
        implements Function<SupervisorAsignadoForEvent, List<DomainEvent>> {

    private final Repository repository;

    public AsignarSupervisorEventUseCaseNoReactivo(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(SupervisorAsignadoForEvent event) {

        JefeSucursal jefeSucursal = JefeSucursal.from(JefeSucursalId.of(event.aggregateRootId()),
                List.of(event));

        jefeSucursal.asignarSupervisor(event.getSupervisorId(),
                event.getNombresSupervisor(),
                event.getApellidosSupervisor(),
                event.getFechaIngresoSupervisor());

        return jefeSucursal.getUncommittedChanges().stream().map(events -> {
            return repository.saveEventNoReactivo(events);
        }).collect(Collectors.toList());
    }

}
