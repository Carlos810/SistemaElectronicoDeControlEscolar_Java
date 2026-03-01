package com.inube.college_schedule.repository;

import com.inube.college_schedule.Dto.RegistroDiarioProjection;
import com.inube.college_schedule.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActividadRepository extends JpaRepository<Actividad, Long> {

    //Se invocan busquedas especificas


    //Consumir vistas
    @Query(value = """
                SELECT
                    NOMBRE as nombre,
                    NOMBRE_ACTIVIDAD as nombreActividad,
                    DESCRIPCION as descripcion,
                    FECHA as fecha,
                    HORA_ENTRADA as horaEntrada,
                    HORA_SALIDA as horaSalida,
                    TIEMPO_AULA_HRS as tiempoAulaHrs
                FROM VW_REGISTRO_DIARIO       
            """, nativeQuery=true) //se requiere el parametro [nativeQuery=true] para indicar a JPA que consuma vista creada en SQL
    List<RegistroDiarioProjection> mostrarActividadesDiarias();



}
