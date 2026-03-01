package com.inube.college_schedule.service;

import com.inube.college_schedule.model.Sala;
import com.inube.college_schedule.repository.ISalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    private ISalaRepository _salaRepository;

    public SalaService(ISalaRepository salaRepository){
        this._salaRepository = salaRepository;
    }

    public List<Sala> listarSalasActivas(Optional<Long>id) throws Exception{
        List<Sala> lSalasActivas = _salaRepository.buscarSalasActivas(id.orElse(null));
        if(id!=null && lSalasActivas.isEmpty()){
            throw new Exception("Sala no encontradacon id: "+id);
        }
        return lSalasActivas;
    }
}
