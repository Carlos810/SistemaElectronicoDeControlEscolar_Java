package com.inube.college_schedule.controller;

import com.inube.college_schedule.model.Usuario;
import com.inube.college_schedule.repository.IUsuarioJpaRepository;
import com.inube.college_schedule.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/web/usuarios")
public class UsuarioController {
    private UsuarioService _usuariosService;
    private IUsuarioJpaRepository _usuarioRepository;

    public UsuarioController(UsuarioService  usuariosService, IUsuarioJpaRepository usuarioRepository){
        this._usuariosService = usuariosService;
        this._usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario> lUsuarios = _usuarioRepository.buscarUsuariosActivos(null);
        model.addAttribute("usuarios",lUsuarios);
        return "usuarios/list";
    }
}
