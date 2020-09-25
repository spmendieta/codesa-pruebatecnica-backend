package com.spmendietadev.microservicios.app.usuarios.services;

import com.spmendietadev.microservicios.app.usuarios.models.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {
    public Iterable<Usuario> findAll();

    public Optional<Usuario> findById(Long id);

    public Usuario save(Usuario usuario);

    public void deleteById(Long id);
}

