package com.inube.college_schedule.controller;

import com.inube.college_schedule.model.Sala;
import com.inube.college_schedule.repository.ISalaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web/salas")
public class SalaController {
    private ISalaRepository _salaRepository;

    public SalaController(ISalaRepository salaRepository){
        this._salaRepository = salaRepository;
    }


    @GetMapping
    public String listarSala(Model model){
        List<Sala> lSalas = _salaRepository.buscarSalasActivas(null);
        model.addAttribute("salas",lSalas);
        return "salas/list";
    }

}
