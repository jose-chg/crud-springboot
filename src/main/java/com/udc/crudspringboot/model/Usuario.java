package com.UDC.crudspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String telefono;
    private String ciudad;
}