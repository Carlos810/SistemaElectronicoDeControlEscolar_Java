package com.inube.college_schedule.controller;

import com.inube.college_schedule.model.Sala;
import com.inube.college_schedule.model.Usuario;
import com.inube.college_schedule.repository.IUsuarioJpaRepository;
import com.inube.college_schedule.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("/new")
    public String mostrarFormulario(@RequestParam(required = false)Long id,Model model) throws Exception {
        Usuario usuario;
        if(id != null){
            List<Usuario> lUsuarios = _usuarioRepository.buscarUsuariosActivos(id);
            if(lUsuarios.isEmpty()){
                throw new Exception("Usuario no encontrado por ID: "+id);
            }
            usuario = lUsuarios.get(0);
        }else{
            usuario = new Usuario();
        }
        model.addAttribute("usuario",usuario);
        return "usuarios/form_add_edit";
    }
    @PostMapping("/guardar")
    public String guardarSala(@ModelAttribute Usuario usuario){
        _usuarioRepository.save(usuario);
        return "redirect:/web/usuarios";
    }

    @GetMapping("/delete/{id}")
    public String confirmarEliminacion(@PathVariable Long id, Model model) {

        Optional<Usuario> usuario = _usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            model.addAttribute("error", "Sala no encontrada");
            return "error/404";
        }

        model.addAttribute("usuario", usuario.get());
        return "usuarios/delete";
    }

    @PostMapping("/toggle/{id}")
    public String cambiarEstado(@PathVariable Long id){

        _usuariosService.toggleEstado(id);

        return "redirect:/web/usuarios";
    }

}
