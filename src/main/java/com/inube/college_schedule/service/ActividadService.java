package com.inube.college_schedule.service;

import com.inube.college_schedule.Dto.RegistroDiarioProjection;
import com.inube.college_schedule.model.Actividad;
import com.inube.college_schedule.model.Usuario;
import com.inube.college_schedule.repository.IActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {
    private IActividadRepository _actividadesRepository;
    public ActividadService(IActividadRepository actividadRepository){
        this._actividadesRepository = actividadRepository;
    }

    public List<RegistroDiarioProjection> listaActividades(Optional<Long> id) throws Exception{
        List<RegistroDiarioProjection> lActividades = _actividadesRepository.mostrarActividadesDiarias(null);
        if(id!= null && lActividades.isEmpty()){
            throw new Exception("No se encontro actividad con ID: "+id);
        }
        return lActividades;
    }

    public void toggleEstado(Long id){
        Actividad actividad = _actividadesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrado"));

        actividad.setEstatus(
                actividad.getEstatus() == 1 ? 0 : 1
        );

        _actividadesRepository.save(actividad);
    }

}
