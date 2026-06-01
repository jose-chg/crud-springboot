package com.UDC.crudspringboot.controller;

import com.UDC.crudspringboot.model.Usuario;
import com.UDC.crudspringboot.service.IUsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String agregar(Model modelo) {
        // Usuario vacío para el formulario nuevo
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Long id, Model modelo) {
        // Buscar usuario por id y cargarlo en el formulario
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario = usuarioServicio.buscar(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {
        usuarioServicio.guardar(usuario);
        return "redirect:/";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuarioServicio.eliminar(usuario);
        return "redirect:/";
    }
}