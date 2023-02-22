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
import com.surtiviveres.empleados.command.AsignarAsesorVentasAsupervisorCommand;
import com.surtiviveres.empleados.events.AsesorVentasAsignadoAsupervisor;
import com.surtiviveres.empleados.events.JefeSucursalCreado;
import com.surtiviveres.empleados.events.SupervisorAsignado;
import com.surtiviveres.empleados.generic.DomainEvent;
import com.surtiviveres.empleados.values.Apellidos;
import com.surtiviveres.empleados.values.FechaIngreso;
import com.surtiviveres.empleados.values.Nombres;
import com.surtiviveres.empleados.values.id.SupervisorId;

@ExtendWith(MockitoExtension.class)
public class AsignarAsesorVentasAsupervisorUseCaseTest {

    @Mock
    private Repository repository;

    private AsignarAsesorVentasAsupervisorUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new AsignarAsesorVentasAsupervisorUseCase(repository);
    }

    @Test
    void successfullScenario() throws ParseException {

        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");

        // Datos del jefe de sucursal
        String JEFE_SUCURSAL_ID = "jefesucursal123";
        String NOMBRES_JEFE_SC = "Juan Diego";
        String APELLIDOS_JEFE_SC = "Corvinus";
        Date FECHA_INGRESO_JEFE_SC = fecha.parse("15-02-2021");

        // Datos del supervisor
        String SUPERVISOR_ID = "super123";
        String NOMBRES_SUPER = "Jorge";
        String APELLIDOS_SUPER = "Contreras";
        Date FECHA_INGRESO_SUPER = fecha.parse("15-02-2022");

        // Datos del asesor de ventas
        String ASESOR_ID = "encargadocaja123";
        String NOMBRES_ASESOR = "Nohemi";
        String APELLIDOS_ASESOR = "Cristancho";
        Date FECHA_INGRESO_ASESOR = fecha.parse("15-02-2023");
        int HORARRIO_INICIO_ASESOR = 8;
        int HORARIO_FIN_ASESOR = 17;

        AsignarAsesorVentasAsupervisorCommand asesorCommand = new AsignarAsesorVentasAsupervisorCommand(
                JEFE_SUCURSAL_ID,
                SUPERVISOR_ID, ASESOR_ID, NOMBRES_ASESOR, APELLIDOS_ASESOR, FECHA_INGRESO_ASESOR,
                HORARRIO_INICIO_ASESOR, HORARIO_FIN_ASESOR);

        SupervisorAsignado supervisorEvent = new SupervisorAsignado(SupervisorId.of(SUPERVISOR_ID),
                new Nombres(NOMBRES_SUPER), new Apellidos(APELLIDOS_SUPER),
                new FechaIngreso(FECHA_INGRESO_SUPER));
        supervisorEvent.setAggregateRootId(JEFE_SUCURSAL_ID);

        JefeSucursalCreado jefeSucuEvent = new JefeSucursalCreado(new Nombres(NOMBRES_JEFE_SC),
                new Apellidos(APELLIDOS_JEFE_SC),
                new FechaIngreso(FECHA_INGRESO_JEFE_SC));
        jefeSucuEvent.setAggregateRootId(JEFE_SUCURSAL_ID);

        Mockito.when(repository.findByIdNoReactivo(JEFE_SUCURSAL_ID))
                .thenReturn(List.of(jefeSucuEvent, supervisorEvent));

        Mockito.when(repository.saveEventNoReactivo(ArgumentMatchers.any(AsesorVentasAsignadoAsupervisor.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> result = useCase.apply(asesorCommand);

        Assertions.assertEquals(asesorCommand.getJefeSucursalId(), result.get(0).aggregateRootId());

        Assertions.assertInstanceOf(AsesorVentasAsignadoAsupervisor.class, result.get(0));
    }
}
