package com.surtiviveres.empleados.bussines.gateways;

import java.util.List;

import com.surtiviveres.empleados.generic.DomainEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Repository {

    DomainEvent saveEventNoReactivo(DomainEvent event);

    List<DomainEvent> findByIdNoReactivo(String agregateRootId);

    void deleteById(String id);

    Flux<DomainEvent> findByIdReactivo(String agregateRootId);

    Mono<DomainEvent> saveEventReactivo(DomainEvent event);
}
