package com.inube.college_schedule.controller;

import com.inube.college_schedule.Dto.RegistroDiarioProjection;
import com.inube.college_schedule.repository.IActividadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web/actividades")
public class ActividadesController {
    private IActividadRepository _actividadesRepository;
    public ActividadesController(IActividadRepository actividadesRepository){
        this._actividadesRepository = actividadesRepository;
    }

    @GetMapping
    public String mostrarReporteActividadesDiarias(Model model){
        List<RegistroDiarioProjection> lActividades = _actividadesRepository.mostrarActividadesDiarias();
        model.addAttribute("actividades",lActividades);
        return "actividades/list";
    }
}
