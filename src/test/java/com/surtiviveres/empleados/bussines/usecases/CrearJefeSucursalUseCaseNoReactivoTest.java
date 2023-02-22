package com.surtiviveres.empleados.bussines.usecases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.surtiviveres.empleados.bussines.gateways.Repository;
import com.surtiviveres.empleados.command.CrearJefeSucursalCommand;
import com.surtiviveres.empleados.events.JefeSucursalCreado;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;

@ExtendWith(MockitoExtension.class)
public class CrearJefeSucursalUseCaseNoReactivoTest {

    @Mock
    private Repository repository;

    private CrearJefeSucursalUseCaseNoReactivo useCase;

    @BeforeEach
    void setUp() {
        useCase = new CrearJefeSucursalUseCaseNoReactivo(repository);
    }

    @Test
    void successfullScenario() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        String JEFE_SUCURSAL_ID = "adlkhajk123";
        String NOMBRES = "Juan Diego";
        String APELLIDOS = "Corvinus";
        Date FECHA_INGRESO = sdf.parse("15-02-2023");

        CrearJefeSucursalCommand command = new CrearJefeSucursalCommand(JEFE_SUCURSAL_ID, NOMBRES, APELLIDOS,
                FECHA_INGRESO);

        JefeSucursalCreado event = new JefeSucursalCreado(new Nombres(NOMBRES), new Apellidos(APELLIDOS),
                new FechaIngreso(FECHA_INGRESO));
        event.setAggregateRootId(JEFE_SUCURSAL_ID);

        Mockito.when(repository.saveEventNoReactivo(ArgumentMatchers.any(JefeSucursalCreado.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> result = useCase.apply(command);

        Assertions.assertEquals(event.aggregateRootId(), result.get(0).aggregateRootId());
    }
}
