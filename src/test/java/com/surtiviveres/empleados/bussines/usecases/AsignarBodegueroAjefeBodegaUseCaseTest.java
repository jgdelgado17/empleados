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
import com.surtiviveres.empleados.command.AsignarBodegueroAjefeBodegaCommand;
import com.surtiviveres.empleados.events.BodegueroAsignadoAjefeBodega;
import com.surtiviveres.empleados.events.JefeBodegaAsignado;
import com.surtiviveres.empleados.events.JefeSucursalCreado;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.JefeBodegaId;

@ExtendWith(MockitoExtension.class)
public class AsignarBodegueroAjefeBodegaUseCaseTest {

    @Mock
    private Repository repository;

    private AsignarBodegueroAjefeBodegaUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new AsignarBodegueroAjefeBodegaUseCase(repository);
    }

    @Test
    void successfullScenario() throws ParseException {

        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");

        // Datos del jefe de sucursal
        String JEFE_SUCURSAL_ID = "jefesucursal123";
        String NOMBRES_JEFE_SC = "Juan Diego";
        String APELLIDOS_JEFE_SC = "Corvinus";
        Date FECHA_INGRESO_JEFE_SC = fecha.parse("15-02-2021");

        // Datos del jefe de bodega
        String JEFE_BODEGA_ID = "super123";
        String NOMBRES_JB = "Sandra";
        String APELLIDOS_JB = "Vanegas";
        Date FECHA_INGRESO_JB = fecha.parse("15-02-2023");

        // Datos del bodeguero
        String BODEGUERO_ID = "encargadocaja123";
        String NOMBRES_BODEGUERO = "Nohemi";
        String APELLIDOS_BODEGUERO = "Cristancho";
        Date FECHA_INGRESO_BODEGUERO = fecha.parse("15-02-2023");
        int HORARRIO_INICIO_BODEGUERO = 8;
        int HORARIO_FIN_BODEGUERO = 17;

        AsignarBodegueroAjefeBodegaCommand bodegueroCommand = new AsignarBodegueroAjefeBodegaCommand(JEFE_SUCURSAL_ID,
                JEFE_BODEGA_ID, BODEGUERO_ID, NOMBRES_BODEGUERO, APELLIDOS_BODEGUERO, FECHA_INGRESO_BODEGUERO,
                HORARRIO_INICIO_BODEGUERO, HORARIO_FIN_BODEGUERO);

        JefeBodegaAsignado jefeBodegaEvent = new JefeBodegaAsignado(JefeBodegaId.of(JEFE_BODEGA_ID),
                new Nombres(NOMBRES_JB), new Apellidos(APELLIDOS_JB), new FechaIngreso(FECHA_INGRESO_JB));
        jefeBodegaEvent.setAggregateRootId(JEFE_SUCURSAL_ID);

        JefeSucursalCreado jefeSucuEvent = new JefeSucursalCreado(new Nombres(NOMBRES_JEFE_SC),
                new Apellidos(APELLIDOS_JEFE_SC),
                new FechaIngreso(FECHA_INGRESO_JEFE_SC));
        jefeSucuEvent.setAggregateRootId(JEFE_SUCURSAL_ID);

        Mockito.when(repository.findByIdNoReactivo(JEFE_SUCURSAL_ID))
                .thenReturn(List.of(jefeSucuEvent, jefeBodegaEvent));

        Mockito.when(repository.saveEventNoReactivo(ArgumentMatchers.any(BodegueroAsignadoAjefeBodega.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> result = useCase.apply(bodegueroCommand);

        Assertions.assertEquals(bodegueroCommand.getJefeSucursalId(), result.get(0).aggregateRootId());

        Assertions.assertInstanceOf(BodegueroAsignadoAjefeBodega.class, result.get(0));
    }
}
