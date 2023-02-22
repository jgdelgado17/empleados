package com.surtiviveres.empleados.bussines.usecases;

import java.util.List;
import java.util.function.Function;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.domain.JefeSucursal;
import com.surtiviveres.empleados.events.SupervisorAsignadoForEvent;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.id.JefeSucursalId;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AsignarSupervisorEventUseCaseReactivo
        implements Function<Mono<SupervisorAsignadoForEvent>, Flux<DomainEvent>> {

    private final Repository repository;

    public AsignarSupervisorEventUseCaseReactivo(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<SupervisorAsignadoForEvent> rMono) {
        return rMono.flatMapIterable(event -> {
            JefeSucursal jefeSucursal = JefeSucursal.from(JefeSucursalId.of(event.aggregateRootId()),
                    List.of(event));
            jefeSucursal.asignarSupervisor(event.getSupervisorId(),
                    event.getNombresSupervisor(),
                    event.getApellidosSupervisor(),
                    event.getFechaIngresoSupervisor());

            return jefeSucursal.getUncommittedChanges();
        }).flatMap(domainEvent -> repository.saveEventReactivo(domainEvent));
    }

}
