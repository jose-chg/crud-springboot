package com.UDC.crudspringboot.controller;

import com.UDC.crudspringboot.model.Usuario;
import com.UDC.crudspringboot.service.IUsuarioServicio;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
        modelo.addAttribute("usuario", new Usuario());
        return "modificar";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Long id, Model modelo) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario = usuarioServicio.buscar(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }

   @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, Errors errores, Model modelo) {
        if (usuario.getId() == null) {
            errores.rejectValue("id", "error.id", "El ID es requerido");
        }
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            errores.rejectValue("nombre", "error.nombre", "El nombre es requerido");
        }
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            errores.rejectValue("email", "error.email", "El email es requerido");
        }
        if (usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            errores.rejectValue("password", "error.password", "El password es requerido");
        }
        if (errores.hasErrors()) {
            modelo.addAttribute("usuario", usuario);
            return "modificar";
        }
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