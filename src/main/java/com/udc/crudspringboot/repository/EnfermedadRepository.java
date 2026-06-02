package com.UDC.crudspringboot.repository;

import com.UDC.crudspringboot.model.Enfermedad;
import org.springframework.data.repository.CrudRepository;

public interface EnfermedadRepository extends CrudRepository<Enfermedad, String> {

}