package com.inube.college_schedule.repository;

import com.inube.college_schedule.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioJpaRepository extends JpaRepository<Usuario,Long> {

    /*Agregar busquedas personalizadas
    * 1.busca por Id con estatus activo
    * 2.buscar todos los registros activos
    * */

    //metodo devuelve un registro por :id o todos los registros activos
    @Query("""
        SELECT U
            FROM Usuario U
        WHERE (:id IS NULL OR U.idUsuario = :id )
    """)
    List<Usuario> buscarUsuariosActivos(@Param("id")Long id);



}
