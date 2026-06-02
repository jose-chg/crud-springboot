package com.UDC.crudspringboot.controller;

import com.UDC.crudspringboot.model.Enfermedad;
import com.UDC.crudspringboot.service.IEnfermedadServicio;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/enfermedades")
public class ControladorEnfermedad {

    @Autowired
    IEnfermedadServicio enfermedadServicio;

    @GetMapping("/")
    public String listar(Model modelo) {
        List<Enfermedad> lista = enfermedadServicio.listarEnfermedades();
        modelo.addAttribute("enfermedades", lista);
        return "enfermedad/index";
    }

    @GetMapping("/agregar")
    public String agregar(Model modelo) {
        modelo.addAttribute("enfermedad", new Enfermedad());
        return "enfermedad/modificar";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") String id, Model modelo) {
        Enfermedad enfermedad = new Enfermedad();
        enfermedad.setId(id);
        enfermedad = enfermedadServicio.buscar(enfermedad);
        modelo.addAttribute("enfermedad", enfermedad);
        return "enfermedad/modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Enfermedad enfermedad, Errors errores, Model modelo) {
        // Validaciones manuales
        if (enfermedad.getNombre() == null || enfermedad.getNombre().trim().isEmpty()) {
            errores.rejectValue("nombre", "error.nombre", "El nombre es requerido");
        }
        if (enfermedad.getNivelGravedad() == null || enfermedad.getNivelGravedad().trim().isEmpty()) {
            errores.rejectValue("nivelGravedad", "error.nivelGravedad", "El nivel de gravedad es requerido");
        }
        if (errores.hasErrors()) {
            modelo.addAttribute("enfermedad", enfermedad);
            return "enfermedad/modificar";
        }
        // Generar UUID si es nueva enfermedad
        if (enfermedad.getId() == null || enfermedad.getId().trim().isEmpty()) {
            enfermedad.setId(UUID.randomUUID().toString());
        }
        enfermedadServicio.guardar(enfermedad);
        return "redirect:/enfermedades/";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") String id) {
        Enfermedad enfermedad = new Enfermedad();
        enfermedad.setId(id);
        enfermedadServicio.eliminar(enfermedad);
        return "redirect:/enfermedades/";
    }
}