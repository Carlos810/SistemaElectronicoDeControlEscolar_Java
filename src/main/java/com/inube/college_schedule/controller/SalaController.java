package com.inube.college_schedule.controller;

import com.inube.college_schedule.model.Sala;
import com.inube.college_schedule.repository.ISalaRepository;
import com.inube.college_schedule.service.SalaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web/salas")
public class SalaController {
    private ISalaRepository _salaRepository;
    private SalaService _salaService;

    public SalaController(ISalaRepository salaRepository, SalaService salaService){

        this._salaRepository = salaRepository;
        this._salaService = salaService;
    }

    @GetMapping
    public String listarSala(Model model){
        List<Sala> lSalas = _salaRepository.buscarSalasActivas(null);
        model.addAttribute("salas",lSalas);
        return "salas/list";
    }

    @GetMapping("/new")
    public String mostrarFormulario(@RequestParam(required = false)Long id , Model model){
        Sala sala;
        if(id!=null){
            List<Sala> resultado = _salaRepository.buscarSalasActivas(id);
            if(resultado.isEmpty()){
                throw new RuntimeException("Sala no encontrada o inactiva");
            }
            sala = resultado.get(0);
        }else{
            sala = new Sala();
        }
        model.addAttribute("sala",sala);
        return "salas/form_add_edit";
    }

    @PostMapping("/guardar")
    public String guardarSala(@ModelAttribute Sala sala){
        _salaRepository.save(sala);
        return "redirect:/web/salas";
    }

    @GetMapping("/delete/{id}")
    public String confirmarEliminacion(@PathVariable Long id, Model model) {

        Optional<Sala> sala = _salaRepository.findById(id);

        if (sala.isEmpty()) {
            model.addAttribute("error", "Sala no encontrada");
            return "error/404";
        }

        model.addAttribute("sala", sala.get());
        return "salas/delete";
    }

    @PostMapping("/toggle/{id}")
    public String cambiarEstado(@PathVariable Long id){

        _salaService.toggleEstado(id);

        return "redirect:/web/salas";
    }
}
