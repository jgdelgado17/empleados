package com.surtiviveres.empleados.bussines.usecases;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.bussines.generic.UseCaseForCommandReactive;
import com.surtiviveres.empleados.command.CrearJefeSucursalCommand;
import com.surtiviveres.empleados.domain.JefeSucursal;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.JefeSucursalId;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CrearJefeSucursalUseCaseReactivo extends UseCaseForCommandReactive<CrearJefeSucursalCommand> {

    private final Repository repository;

    public CrearJefeSucursalUseCaseReactivo(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CrearJefeSucursalCommand> rMono) {
        return rMono.flatMapIterable(command -> {

            JefeSucursal jefeSucursal = new JefeSucursal(JefeSucursalId.of(command.getJefeSucursalId()),
                    new Nombres(command.getNombres()),
                    new Apellidos(command.getApellidos()),
                    new FechaIngreso(command.getFechaIngreso()));

            return jefeSucursal.getUncommittedChanges();

        }).flatMap(event -> repository.saveEventReactivo(event));
    }
}
