package com.spmendietadev.microservicios.app.usuarios.services;

import com.spmendietadev.microservicios.app.usuarios.models.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Iterable<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    void deleteById(Long id);
}

