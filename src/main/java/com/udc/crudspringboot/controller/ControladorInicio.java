package com.udc.crudspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorInicio {

    @GetMapping("/")
    public String inicio() {
        System.out.println("Ejecutando el controlador Inicio");
        return "Este es el inicio - CrudSpringBoot";
    }
}