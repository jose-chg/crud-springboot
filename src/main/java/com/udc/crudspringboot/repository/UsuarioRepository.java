package com.UDC.crudspringboot.repository;

import com.UDC.crudspringboot.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}