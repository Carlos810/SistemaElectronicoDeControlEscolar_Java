package com.inube.college_schedule.service;

import com.inube.college_schedule.model.Usuario;
import com.inube.college_schedule.repository.IUsuarioJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private IUsuarioJpaRepository _usuarioJpaRepository;

    public UsuarioService(IUsuarioJpaRepository usuarioRepository){
        this._usuarioJpaRepository = usuarioRepository;
    }

    public List<Usuario> findAll(){
        return this._usuarioJpaRepository.findAll();
    }

    public List<Usuario> BuscarActivos(Optional<Long> id) throws Exception {
        List<Usuario> lUsuarios = _usuarioJpaRepository.buscarUsuariosActivos(id.orElse(null));
        //validando desde la capa service.
        if(id != null && lUsuarios.isEmpty()){
            throw new Exception("Usuario no encontrado con id: " + id);
        }
        return lUsuarios;
    };

    @Transactional
    public void  toggleEstado(Long id){
        Usuario usuario = _usuarioJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setEstatus(
                usuario.getEstatus() == 1 ? 0 : 1
        );
        _usuarioJpaRepository.save(usuario);
    }

}
