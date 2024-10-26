package com.VenTrix.com.VenTrix.Controladores;

import com.VenTrix.com.VenTrix.Entidades.Usuario;
import com.VenTrix.com.VenTrix.Servicios.Usuario_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "localhost:5173")
@RestController
@RequestMapping("/usuarios")
public class Usuario_Controlador {

    // Aquí se definiran las rutas para los endpoints de usuarios

    @Autowired
    private Usuario_Servicio servicio;

    @PostMapping() // Crear un nuevo usuario
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario saveUsuario = servicio.addUsuario(usuario);
        return new ResponseEntity<>(saveUsuario, HttpStatus.CREATED);
    }

    @GetMapping() // Listar todos los usuarios
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> lista = servicio.getAllUsuarios();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}") // Obtener un usuario por su ID
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id){
        Usuario usuario = servicio.getUsuarioById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}") // Actualizar un usuario
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        Usuario usuarioActualizado = servicio.updateUsuario(id, usuario);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // Eliminar un usuario
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id){
        servicio.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
