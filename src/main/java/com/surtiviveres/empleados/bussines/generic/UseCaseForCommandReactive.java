package com.surtiviveres.empleados.bussines.generic;

import java.util.function.Function;

import com.surtiviveres.empleados.generic.Command;
import com.surtiviveres.empleados.generic.DomainEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class UseCaseForCommandReactive<R extends Command> implements Function<Mono<R>, Flux<DomainEvent>> {
    public abstract Flux<DomainEvent> apply(Mono<R> rMono);
}
