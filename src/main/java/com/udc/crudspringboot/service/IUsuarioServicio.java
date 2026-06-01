package com.UDC.crudspringboot.service;

import com.UDC.crudspringboot.model.Usuario;
import java.util.List;

public interface IUsuarioServicio {

    public List<Usuario> listarUsuarios();
    public void guardar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public Usuario buscar(Usuario usuario);
}