package com.surtiviveres.empleados.bussines.generic;

import java.util.List;

import com.surtiviveres.empleados.generic.Command;
import com.surtiviveres.empleados.generic.DomainEvent;

public interface UseCaseForCommandNoReactive <R extends Command> {
    List<DomainEvent> apply(R command);
}
