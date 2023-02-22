package com.surtiviveres.empleados.bussines.usecases;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.bussines.generic.UseCaseForCommandReactive;
import com.surtiviveres.empleados.command.AsignarSupervisorCommand;
import com.surtiviveres.empleados.domain.JefeSucursal;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.JefeSucursalId;
import com.surtiviveres.empleados.values.id.SupervisorId;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AsignarSupervisorUseCaseReactivo extends UseCaseForCommandReactive<AsignarSupervisorCommand> {

    private final Repository repository;

    public AsignarSupervisorUseCaseReactivo(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<AsignarSupervisorCommand> rMono) {
        return rMono.flatMapMany(command -> repository.findByIdReactivo(command.getJefeSucursalId())
                .collectList()
                .flatMapIterable(events -> {

                    JefeSucursal jefeSucursal = JefeSucursal.from(JefeSucursalId.of(command.getJefeSucursalId()),
                            events);

                    jefeSucursal.asignarSupervisor(SupervisorId.of(command.getSupervisorId()),
                            new Nombres(command.getNombres()),
                            new Apellidos(command.getApellidos()),
                            new FechaIngreso(command.getFechaIngreso()));

                    return jefeSucursal.getUncommittedChanges();
                })
                .flatMap(event -> repository.saveEventReactivo(event)));
    }

}
