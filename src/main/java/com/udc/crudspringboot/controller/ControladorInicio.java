package com.UDC.crudspringboot.controller;

import com.UDC.crudspringboot.model.Usuario;
import com.UDC.crudspringboot.service.IUsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorInicio {

    @Autowired
    IUsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String inicio(Model modelo) {
        List<Usuario> listaUsuarios = usuarioServicio.listarUsuarios();
        modelo.addAttribute("usuarios", listaUsuarios);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Usuario usuario) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {
        usuarioServicio.guardar(usuario);
        return "redirect:/";
    }

    @GetMapping("/eliminar")
    public String eliminar(Usuario usuario) {
        usuarioServicio.eliminar(usuario);
        return "redirect:/";
    }
}

