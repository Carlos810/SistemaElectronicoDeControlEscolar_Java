package com.inube.college_schedule.service;

import com.inube.college_schedule.Dto.RegistroDiarioProjection;
import com.inube.college_schedule.repository.IActividadRepository;

import java.util.List;
import java.util.Optional;

public class ActividadService {
    private IActividadRepository _actividadesRepository;
    public ActividadService(IActividadRepository actividadRepository){
        this._actividadesRepository = actividadRepository;
    }

    public List<RegistroDiarioProjection> listaActividades(Optional<Long> id) throws Exception{
        List<RegistroDiarioProjection> lActividades = _actividadesRepository.mostrarActividadesDiarias();
        if(id!= null && lActividades.isEmpty()){
            throw new Exception("No se encontro actividad con ID: "+id);
        }
        return lActividades;
    }

}
