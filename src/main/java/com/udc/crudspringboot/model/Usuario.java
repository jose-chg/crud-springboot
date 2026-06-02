package com.UDC.crudspringboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "El ID es requerido")
    private Long id;

    @NotEmpty(message = "El nombre es requerido")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotEmpty(message = "El email es requerido")
    @Email(message = "Formato de email incorrecto")
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @NotEmpty(message = "El password es requerido")
    @Column(nullable = false, length = 255)
    private String password;

    private String telefono;
    private String ciudad;
}