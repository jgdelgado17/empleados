package com.surtiviveres.empleados.domain;

import java.util.HashSet;

import com.surtiviveres.empleados.events.AsesorVentasAsignadoAsupervisor;
import com.surtiviveres.empleados.events.AsesorVentasDesAsignadoAsupervisor;
import com.surtiviveres.empleados.events.BodegueroAsignadoAjefeBodega;
import com.surtiviveres.empleados.events.BodegueroDesAsignadoAjefeBodega;
import com.surtiviveres.empleados.events.CajeroAsignadoAsupervisor;
import com.surtiviveres.empleados.events.CajeroDesAsignadoAsupervisor;
import com.surtiviveres.empleados.events.JefeBodegaAsignado;
import com.surtiviveres.empleados.events.JefeBodegaDesAsignado;
import com.surtiviveres.empleados.events.JefeSucursalCreado;
import com.surtiviveres.empleados.events.SupervisorAsignado;
import com.surtiviveres.empleados.events.SupervisorDesAsignado;
import com.surtiviveres.empleados.generic.EventChange;

public class JefeSucursalEventChange extends EventChange {

        public JefeSucursalEventChange(JefeSucursal jefeSucursal) {

                apply((JefeSucursalCreado event) -> {
                        jefeSucursal.nombres = event.getNombres();
                        jefeSucursal.apellidos = event.getApellidos();
                        jefeSucursal.fechaIngreso = event.getFechaIngreso();
                        jefeSucursal.supervisoresAcargo = new HashSet<>();
                        jefeSucursal.jefesBodegaAcargo = new HashSet<>();
                });

                apply((SupervisorAsignado event) -> {
                        Supervisor supervisor = new Supervisor(event.getSupervisorId(), event.getNombres(),
                                        event.getApellidos(),
                                        event.getFechaIngreso());
                        jefeSucursal.supervisoresAcargo = new HashSet<>();
                        jefeSucursal.jefesBodegaAcargo = new HashSet<>();
                        jefeSucursal.supervisoresAcargo.add(supervisor);
                });

                apply((SupervisorDesAsignado event) -> {
                        Supervisor supervisor = new Supervisor(event.getSupervisorId(), event.getNombres(),
                                        event.getApellidos(),
                                        event.getFechaIngreso());
                        jefeSucursal.supervisoresAcargo.remove(supervisor);
                });

                apply((JefeBodegaAsignado event) -> {
                        JefeBodega jefeBodega = new JefeBodega(event.getJefeBodegaId(), event.getNombres(),
                                        event.getApellidos(),
                                        event.getFechaIngreso());
                        jefeSucursal.jefesBodegaAcargo.add(jefeBodega);
                });

                apply((JefeBodegaDesAsignado event) -> {
                        JefeBodega jefeBodega = new JefeBodega(event.getJefeBodegaId(), event.getNombres(),
                                        event.getApellidos(),
                                        event.getFechaIngreso());
                        jefeSucursal.jefesBodegaAcargo.remove(jefeBodega);
                });

                apply((CajeroAsignadoAsupervisor event) -> {
                        EncargadoCaja encargadoCaja = new EncargadoCaja(event.getEncargadoCajaId(), event.getNombres(),
                                        event.getApellidos(), event.getFechaIngreso(), event.getHorario());

                        Supervisor supervisor = jefeSucursal.supervisoresAcargo.stream()
                                        .filter(superv -> superv.identity().value()
                                                        .equals(event.getSupervisorId().value()))
                                        .findFirst()
                                        .orElse(null);

                        supervisor.asignarCajero(encargadoCaja);
                });

                apply((CajeroDesAsignadoAsupervisor event) -> {
                        EncargadoCaja encargadoCaja = new EncargadoCaja(event.getEncargadoCajaId(), event.getNombres(),
                                        event.getApellidos(), event.getFechaIngreso(), event.getHorario());

                        Supervisor supervisor = jefeSucursal.supervisoresAcargo.stream()
                                        .filter(superv -> superv.identity().value()
                                                        .equals(event.getSupervisorId().value()))
                                        .findFirst()
                                        .orElse(null);

                        supervisor.desAsignarCajero(encargadoCaja);
                });

                apply((AsesorVentasAsignadoAsupervisor event) -> {
                        AsesorDeVentas asesorDeVentas = new AsesorDeVentas(event.getAsesorDeVentasId(),
                                        event.getNombres(),
                                        event.getApellidos(), event.getFechaIngreso(), event.getHorario());

                        Supervisor supervisor = jefeSucursal.supervisoresAcargo.stream()
                                        .filter(superv -> superv.identity().value()
                                                        .equals(event.getSupervisorId().value()))
                                        .findFirst()
                                        .orElse(null);

                        supervisor.asignarAsesor(asesorDeVentas);
                });

                apply((AsesorVentasDesAsignadoAsupervisor event) -> {
                        AsesorDeVentas asesorDeVentas = new AsesorDeVentas(event.getAsesorDeVentasId(),
                                        event.getNombres(),
                                        event.getApellidos(), event.getFechaIngreso(), event.getHorario());

                        Supervisor supervisor = jefeSucursal.supervisoresAcargo.stream()
                                        .filter(superv -> superv.identity().value()
                                                        .equals(event.getSupervisorId().value()))
                                        .findFirst()
                                        .orElse(null);

                        supervisor.desAsignarAsesor(asesorDeVentas);
                });

                apply((BodegueroAsignadoAjefeBodega event) -> {
                        Bodeguero bodeguero = new Bodeguero(event.getBodegueroId(), event.getNombres(),
                                        event.getApellidos(), event.getFechaIngreso(), event.getHorario());

                        JefeBodega supervisor = jefeSucursal.jefesBodegaAcargo.stream()
                                        .filter(superv -> superv.identity().value()
                                                        .equals(event.getJefeBodegaId().value()))
                                        .findFirst()
                                        .orElse(null);

                        supervisor.asignarBodeguero(bodeguero);
                });

                apply((BodegueroDesAsignadoAjefeBodega event) -> {
                        Bodeguero bodeguero = new Bodeguero(event.getBodegueroId(), event.getNombres(),
                                        event.getApellidos(), event.getFechaIngreso(), event.getHorario());

                        JefeBodega supervisor = jefeSucursal.jefesBodegaAcargo.stream()
                                        .filter(superv -> superv.identity().value()
                                                        .equals(event.getJefeBodegaId().value()))
                                        .findFirst()
                                        .orElse(null);

                        supervisor.desAsignarBodeguero(bodeguero);
                });
        }
}
