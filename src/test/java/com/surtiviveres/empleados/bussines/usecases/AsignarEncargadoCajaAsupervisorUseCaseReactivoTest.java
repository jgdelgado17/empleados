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
import com.surtiviveres.empleados.command.AsignarEncargadoCajaAsupervisorCommand;
import com.surtiviveres.empleados.events.CajeroAsignadoAsupervisor;
import com.surtiviveres.empleados.events.JefeSucursalCreado;
import com.surtiviveres.empleados.events.SupervisorAsignado;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.SupervisorId;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class AsignarEncargadoCajaAsupervisorUseCaseReactivoTest {

    @Mock
    private Repository repository;

    private AsignarEncargadoCajaAsupervisorUseCaseReactivo useCase;

    @BeforeEach
    void setUp() {
        useCase = new AsignarEncargadoCajaAsupervisorUseCaseReactivo(repository);
    }

    @Test
    void successfullScenario() throws ParseException {
        // Arrange
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");

        // Datos del jefe de sucursal
        String JEFE_SUCURSAL_ID = "jefesucursal123";
        String NOMBRES_JEFE_SC = "Juan Diego";
        String APELLIDOS_JEFE_SC = "Corvinus";
        Date FECHA_INGRESO_JEFE_SC = fecha.parse("15-02-2021");

        // Datos del supervisor
        String SUPERVISOR_ID = "super123";
        String NOMBRES_SUPER = "Sandra";
        String APELLIDOS_SUPER = "Vanegas";
        Date FECHA_INGRESO_SUPER = fecha.parse("15-02-2022");

        // Datos del cajero
        String ENCARGADO_CAJA_ID = "encargadocaja123";
        String NOMBRES_CAJERO = "Angela";
        String APELLIDOS_CAJERO = "Casadiegos";
        Date FECHA_INGRESO_CAJERO = fecha.parse("15-02-2023");
        int HORARRIO_INICIO_CAJERO = 8;
        int HORARIO_FIN_CAJERO = 17;

        AsignarEncargadoCajaAsupervisorCommand cajeroCommand = new AsignarEncargadoCajaAsupervisorCommand(
                JEFE_SUCURSAL_ID,
                SUPERVISOR_ID, ENCARGADO_CAJA_ID, NOMBRES_CAJERO, APELLIDOS_CAJERO,
                FECHA_INGRESO_CAJERO,
                HORARRIO_INICIO_CAJERO, HORARIO_FIN_CAJERO);

        SupervisorAsignado supervisorEvent = new SupervisorAsignado(SupervisorId.of(SUPERVISOR_ID),
                new Nombres(NOMBRES_SUPER), new Apellidos(APELLIDOS_SUPER),
                new FechaIngreso(FECHA_INGRESO_SUPER));
        supervisorEvent.setAggregateRootId(JEFE_SUCURSAL_ID);

        JefeSucursalCreado jefeSucuEvent = new JefeSucursalCreado(new Nombres(NOMBRES_JEFE_SC),
                new Apellidos(APELLIDOS_JEFE_SC),
                new FechaIngreso(FECHA_INGRESO_JEFE_SC));
        jefeSucuEvent.setAggregateRootId(JEFE_SUCURSAL_ID);

        Mockito.when(repository.findByIdReactivo(JEFE_SUCURSAL_ID))
                .thenReturn(Flux.just(jefeSucuEvent, supervisorEvent));

        Mockito.when(repository.saveEventReactivo(ArgumentMatchers.any(CajeroAsignadoAsupervisor.class)))
                .thenAnswer(invocationOnMock -> {
                    return Mono.just(invocationOnMock.getArgument(0));
                });

        // Act
        Flux<DomainEvent> result = useCase.apply(Mono.just(cajeroCommand));

        StepVerifier.create(result)
                // Assert
                .expectNextMatches(eventResult -> {

                    Assertions.assertEquals(jefeSucuEvent.aggregateRootId(), eventResult.aggregateRootId());
                    Assertions.assertInstanceOf(CajeroAsignadoAsupervisor.class, eventResult);

                    return eventResult.aggregateRootId().equals(jefeSucuEvent.aggregateRootId());
                })
                .verifyComplete();

        Mockito.verify(repository, Mockito.times(1))
                .saveEventReactivo(Mockito.any());

        Mockito.verify(repository, Mockito.times(1))
                .findByIdReactivo("jefesucursal123");

    }
}
