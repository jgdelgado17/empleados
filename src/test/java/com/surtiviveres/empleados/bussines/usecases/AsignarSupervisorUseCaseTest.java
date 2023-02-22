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
import com.surtiviveres.empleados.command.AsignarSupervisorCommand;
import com.surtiviveres.empleados.events.JefeSucursalCreado;
import com.surtiviveres.empleados.events.SupervisorAsignado;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;

@ExtendWith(MockitoExtension.class)
public class AsignarSupervisorUseCaseTest {

    @Mock
    private Repository repository;

    private AsignarSupervisorUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new AsignarSupervisorUseCase(repository);
    }

    @Test
    void successfullScenario() throws ParseException {

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

        AsignarSupervisorCommand command = new AsignarSupervisorCommand(JEFE_SUCURSAL_ID, SUPERVISOR_ID, NOMBRES_SUPER,
                APELLIDOS_SUPER, FECHA_INGRESO_SUPER);

        JefeSucursalCreado event = new JefeSucursalCreado(new Nombres(NOMBRES_JEFE_SC),
                new Apellidos(APELLIDOS_JEFE_SC),
                new FechaIngreso(FECHA_INGRESO_JEFE_SC));
        event.setAggregateRootId(JEFE_SUCURSAL_ID);

        Mockito.when(repository.findByIdNoReactivo(JEFE_SUCURSAL_ID))
                .thenReturn(List.of(event));

        Mockito.when(repository.saveEventNoReactivo(ArgumentMatchers.any(SupervisorAsignado.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> result = useCase.apply(command);

        Assertions.assertEquals(command.getJefeSucursalId(), result.get(0).aggregateRootId());
        Assertions.assertInstanceOf(SupervisorAsignado.class, result.get(0));

        Mockito.verify(repository, Mockito.times(1))
                .saveEventNoReactivo(Mockito.any());

        Mockito.verify(repository, Mockito.times(1))
                .findByIdNoReactivo("jefesucursal123");

    }

}
