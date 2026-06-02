package com.UDC.crudspringboot.service;

import com.UDC.crudspringboot.model.Enfermedad;
import com.UDC.crudspringboot.repository.EnfermedadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnfermedadServicioImp implements IEnfermedadServicio {

    @Autowired
    EnfermedadRepository enfermedadRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Enfermedad> listarEnfermedades() {
        return (List<Enfermedad>) enfermedadRepository.findAll();
    }

    @Transactional
    @Override
    public void guardar(Enfermedad enfermedad) {
        enfermedadRepository.save(enfermedad);
    }

    @Transactional
    @Override
    public void eliminar(Enfermedad enfermedad) {
        enfermedadRepository.delete(enfermedad);
    }

    @Transactional(readOnly = true)
    @Override
    public Enfermedad buscar(Enfermedad enfermedad) {
        return enfermedadRepository.findById(enfermedad.getId()).orElse(null);
    }
}
