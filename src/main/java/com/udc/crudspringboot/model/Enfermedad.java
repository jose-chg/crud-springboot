package com.UDC.crudspringboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Data;

@Entity
@Table(name = "enfermedades")
@Data
public class Enfermedad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 36)
    private String id;

    @NotEmpty(message = "El nombre es requerido")
    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(name = "nombre_cientifico", length = 200)
    private String nombreCientifico;

    @NotEmpty(message = "El nivel de gravedad es requerido")
    @Column(name = "nivel_gravedad", nullable = false, length = 30)
    private String nivelGravedad;

    @Column(columnDefinition = "TEXT")
    private String sintomas;

    @Column(columnDefinition = "TEXT")
    private String medicamentos;

    @Column(name = "es_contagiosa")
    private Boolean esContagiosa = false;

    @Column(name = "es_cubierta_por_pos")
    private Boolean esCubiertaPorPos = false;

    @Column(name = "requiere_incapacidad")
    private Boolean requiereIncapacidad = false;
}