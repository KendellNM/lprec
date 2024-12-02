package pe.edu.upeu.LP2_clase01.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.LP2_clase01.entity.Usuario;
import pe.edu.upeu.LP2_clase01.exception.ResourceNotFoundException;
import pe.edu.upeu.LP2_clase01.service.UsuariosService;
import pe.edu.upeu.LP2_clase01.serviceImpl.UsuariosServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping("api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuariosServiceImpl usuariosServiceImpl;


    @GetMapping
    public ResponseEntity<List<Usuario>> readAll() {
        try {
            List<Usuario> usuariosList = usuariosService.readAll();
            if (usuariosList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(usuariosList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario c) {
        try {
            Usuario usuarios = usuariosService.create(c);
            return new ResponseEntity<>(usuarios, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("El nombre de usuario ya existe.", HttpStatus.CONFLICT);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuariosId(@PathVariable("id") Long id) {
        try {
            Optional<Usuario> usuario = usuariosService.read(id);
            if (usuario.isPresent()) {
                return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delUsuarios(@PathVariable("id") Long id) {
        try {
            usuariosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuarios(@PathVariable("id") Long id, @RequestBody Usuario c) {
        Optional<Usuario> usuarios = usuariosService.read(id);
        if (usuarios.isPresent()) {
            return new ResponseEntity<>(usuariosService.update(c), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{idUsuario}/roles/{idRol}")
    public ResponseEntity<Usuario> inscribirUsuariosconRol(
            @PathVariable Long idUsuario, @PathVariable Long idRol) {
        try {
            Usuario usuario = usuariosServiceImpl.inscribirUsuariosconRol(idUsuario, idRol);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
