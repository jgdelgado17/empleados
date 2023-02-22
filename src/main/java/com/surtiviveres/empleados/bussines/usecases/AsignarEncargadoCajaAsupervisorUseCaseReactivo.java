package com.surtiviveres.empleados.bussines.usecases;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.bussines.generic.UseCaseForCommandReactive;
import com.surtiviveres.empleados.command.AsignarEncargadoCajaAsupervisorCommand;
import com.surtiviveres.empleados.domain.JefeSucursal;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Horario;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.EncargadoCajaId;
import com.surtiviveres.empleados.values.id.JefeSucursalId;
import com.surtiviveres.empleados.values.id.SupervisorId;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AsignarEncargadoCajaAsupervisorUseCaseReactivo
        extends UseCaseForCommandReactive<AsignarEncargadoCajaAsupervisorCommand> {

    private final Repository repository;

    public AsignarEncargadoCajaAsupervisorUseCaseReactivo(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<AsignarEncargadoCajaAsupervisorCommand> rMono) {
        return rMono.flatMapMany(command -> repository.findByIdReactivo(command.getJefeSucursalId())
                .collectList()
                .flatMapIterable(events -> {

                    JefeSucursal jefeSucursal = JefeSucursal.from(JefeSucursalId.of(command.getJefeSucursalId()),
                            events);

                    jefeSucursal.asignarCajeroAsupervisor(SupervisorId.of(command.getSupervisorId()),
                            EncargadoCajaId.of(command.getEncargadoCajaId()),
                            new Nombres(command.getNombres()),
                            new Apellidos(command.getApellidos()),
                            new FechaIngreso(command.getFechaIngreso()),
                            new Horario(command.getHorarioInicio(), command.getHorarioFin()));

                    return jefeSucursal.getUncommittedChanges();
                })
                .flatMap(event -> repository.saveEventReactivo(event)));
    }

}
