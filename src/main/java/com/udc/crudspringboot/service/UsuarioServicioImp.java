package com.UDC.crudspringboot.service;

import com.UDC.crudspringboot.model.Usuario;
import com.UDC.crudspringboot.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicioImp implements IUsuarioServicio {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public void eliminar(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario buscar(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId()).orElse(null);
    }
}