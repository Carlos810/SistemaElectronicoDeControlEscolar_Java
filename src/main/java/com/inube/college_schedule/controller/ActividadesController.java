package com.inube.college_schedule.controller;

import com.inube.college_schedule.Dto.RegistroDiarioProjection;
import com.inube.college_schedule.model.Actividad;
import com.inube.college_schedule.model.Sala;
import com.inube.college_schedule.repository.IActividadRepository;
import com.inube.college_schedule.repository.ISalaRepository;
import com.inube.college_schedule.repository.IUsuarioJpaRepository;
import com.inube.college_schedule.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/web/actividades")
public class ActividadesController {
    private IActividadRepository _actividadesRepository;
    private ISalaRepository _salaRepository;
    private IUsuarioJpaRepository _usuarioRepository;

    public ActividadesController(IActividadRepository actividadesRepository,
        ISalaRepository salaRepository, IUsuarioJpaRepository usuarioRepository
    ){
        this._actividadesRepository = actividadesRepository;
        this._salaRepository = salaRepository;
        this._usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String mostrarReporteActividadesDiarias(Model model){
        List<RegistroDiarioProjection> lActividades = _actividadesRepository.mostrarActividadesDiarias(null);
        model.addAttribute("actividades",lActividades);
        return "actividades/list";
    }

    @GetMapping("/new")
    public String mostrarFormulario(@RequestParam(required=false)Long id, Model model){
        Actividad actividad;
        if(id != null){
            actividad = _actividadesRepository
                    .findById(id)
                    .orElse(new Actividad());
            //Actividad vacía para el formulario
            model.addAttribute("actividad", actividad);
            //Catálogos
           /* model.addAttribute("usuarios", _usuarioRepository.buscarUsuariosActivos(null));
            model.addAttribute("salas", _salaRepository.buscarSalasActivas(null));*/

            Long usuarioId = actividad.getUsuario() != null
                    ? actividad.getUsuario().getIdUsuario()
                    : null;

            Long salaId = actividad.getSala() != null
                    ? actividad.getSala().getIdSala()
                    : null;

            model.addAttribute("usuarios",
                    _usuarioRepository.buscarUsuariosActivos(usuarioId));

            model.addAttribute("salas",
                    _salaRepository.buscarSalasActivas(salaId));
        }else{
            //Actividad vacía para el formulario
            model.addAttribute("actividad", new Actividad());
            //Catálogos
            model.addAttribute("usuarios", _usuarioRepository.buscarUsuariosActivos(null));
            model.addAttribute("salas", _salaRepository.buscarSalasActivas(null));
        }

        return "actividades/form_add_edit";
    }

    @PostMapping("/guardar")
    public String guardarSala(@ModelAttribute Actividad actividad){
        _actividadesRepository.save(actividad);
        return "redirect:/web/actividades";
    }


}
