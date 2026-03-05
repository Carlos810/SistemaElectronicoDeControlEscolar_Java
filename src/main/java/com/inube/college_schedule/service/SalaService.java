package com.inube.college_schedule.service;

import com.inube.college_schedule.model.Sala;
import com.inube.college_schedule.repository.ISalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @Transactional
    public void toggleEstado(Long id){

        Sala sala = _salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada"));

        System.out.println("Estado actual: " + sala.getDisponible());

        sala.setDisponible(
                sala.getDisponible() == 1 ? 0 : 1
        );

        System.out.println("Estado nuevo: " + sala.getDisponible());

        _salaRepository.save(sala);
    }


}
