package com.spmendietadev.microservicios.app.usuarios.models.repository;

import com.spmendietadev.microservicios.app.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
