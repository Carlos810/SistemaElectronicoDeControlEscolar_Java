package com.inube.college_schedule.repository;

import com.inube.college_schedule.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISalaRepository  extends JpaRepository<Sala,Long> {

    /*@Query("""
        SELECT s
        FROM Sala s 
            WHERE s.disponible = 1
        AND(:id IS NULL OR s.idSala = :id) 
        """)
    List<Sala> buscarSalasActivas(@Param("id")Long id);*/

    @Query("""
        SELECT s
        FROM Sala s 
            WHERE (:id IS NULL OR s.idSala = :id)
        """)
    List<Sala> buscarSalasActivas(@Param("id")Long id);


}
