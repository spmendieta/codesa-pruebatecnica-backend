package com.spmendietadev.microservicios.app.usuarios.controller;

import com.spmendietadev.microservicios.app.usuarios.models.entity.Usuario;
import com.spmendietadev.microservicios.app.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crearUsuario")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
    }

    @GetMapping("/obtenerUsuarios")
    public ResponseEntity<?> obtenerUsuarios() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping("obtenerUsuarioId/{id}")
    public ResponseEntity<?> obtenerUsuarioId(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @PutMapping("/editarUsuario/{id}")
    public ResponseEntity<?> editarUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
        Optional<Usuario> findUser = usuarioService.findById(id);

        if (findUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario editedUser = findUser.get();

        editedUser.setIdRol(usuario.getIdRol());
        editedUser.setIdRol(usuario.getIdRol());
        editedUser.setNombre(usuario.getNombre());
        editedUser.setActivo(usuario.getActivo());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(editedUser));
    }

    @DeleteMapping("/inactivarUsuario/{id}")
    public ResponseEntity<?> inactivarUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
