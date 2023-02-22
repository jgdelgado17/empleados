package com.surtiviveres.empleados.bussines.usecases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.events.SupervisorAsignado;
import com.surtiviveres.empleados.events.SupervisorAsignadoForEvent;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.SupervisorId;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class AsignarSupervisorEventUseCaseReactivoTest {
    @Mock
    private Repository repository;

    private AsignarSupervisorEventUseCaseReactivo useCase;

    @BeforeEach
    void setUp() {
        useCase = new AsignarSupervisorEventUseCaseReactivo(repository);
    }

    @Test
    void successfullScenario() throws ParseException {
        // Arrange
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Datos del jefe de sucursal
        String JEFE_SUCURSAL_ID = "jefesucursal123";
        String NOMBRES_JEFE_SC = "Juan Diego";
        String APELLIDOS_JEFE_SC = "Corvinus";
        Date FECHA_INGRESO_JEFE_SC = sdf.parse("15-02-2022");

        // Datos del supervisor
        String SUPERVISOR_ID = "super123";
        String NOMBRES_SUPER = "Sandra";
        String APELLIDOS_SUPER = "Vanegas";
        Date FECHA_INGRESO_SUPER = sdf.parse("15-02-2023");

        SupervisorAsignadoForEvent event = new SupervisorAsignadoForEvent(
                new Nombres(NOMBRES_JEFE_SC),
                new Apellidos(APELLIDOS_JEFE_SC),
                new FechaIngreso(FECHA_INGRESO_JEFE_SC),
                SupervisorId.of(SUPERVISOR_ID),
                new Nombres(NOMBRES_SUPER),
                new Apellidos(APELLIDOS_SUPER),
                new FechaIngreso(FECHA_INGRESO_SUPER));
        event.setAggregateRootId(JEFE_SUCURSAL_ID);

        Mockito.when(repository.saveEventReactivo(ArgumentMatchers.any(SupervisorAsignado.class)))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        // Act
        Flux<DomainEvent> result = useCase.apply(Mono.just(event));

        StepVerifier.create(result)
                // Assert
                .expectNextMatches(eventResult -> {

                    Assertions.assertEquals(event.aggregateRootId(), eventResult.aggregateRootId());
                    Assertions.assertInstanceOf(SupervisorAsignado.class, eventResult);

                    return eventResult.aggregateRootId().equals(event.aggregateRootId());
                })
                .verifyComplete();

        Mockito.verify(repository, Mockito.times(1))
                .saveEventReactivo(Mockito.any());
    }
}
