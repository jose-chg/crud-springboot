package com.UDC.crudspringboot.service;

import com.UDC.crudspringboot.model.Enfermedad;
import java.util.List;

public interface IEnfermedadServicio {
    public List<Enfermedad> listarEnfermedades();
    public void guardar(Enfermedad enfermedad);
    public void eliminar(Enfermedad enfermedad);
    public Enfermedad buscar(Enfermedad enfermedad);
}