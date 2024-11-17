package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Rol_Usuario;
import com.VenTrix.com.VenTrix.Entidades.Usuario;
import com.VenTrix.com.VenTrix.Repositorios.Usuario_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Usuario_Servicio {

    @Autowired
    private Usuario_Repositorio repo;

    // Implementar métodos para CRUD en la entidad Usuario

    public Usuario addUsuario(Usuario usuario) { // Crear un nuevo usuario
        return repo.save(usuario);
    }

    public Usuario login(String correo, String password) { // Login de un usuario
        return repo.findByCorreoAndPassword(correo, password);
    }

    public String getUsuarioByCorreo(String correo) { // Obtener un usuario por su correo
        Usuario usuario = repo.findByCorreo(correo);
        if (usuario != null) {
            return usuario.getDocumento();
        } else {
            return null;
        }
    }

    public Rol_Usuario getUsuarioByDocumento(String coreo) { // Obtener un usuario por su correo
        Usuario usuario = repo.findByCorreo(coreo);
        if (usuario != null) {
            return usuario.getRol();
        } else {
            return null;
        }
    }

    public String getUsuarioBySucursal(String documento) { // Obtener un usuario por su correo
        Usuario usuario = repo.findById(documento).orElse(null);
        if (usuario != null) {
            return usuario.getSucursal();
        } else {
            return null;
        }
    }

    public Usuario getUsuarioById(String id) { // Obtener un usuario por su ID
        return repo.findById(id).orElse(null);
    }

    public String getUsuarioByNombre(String id) { // Obtener un usuario por su ID
        Usuario usuario = repo.findById(id).orElse(null);
        if (usuario != null) {
            return usuario.getNombre();
        } else {
            return null;
        }
    }

    public Usuario updateUsuario(Integer id, Usuario usuario) { // Actualizar un usuario
        return repo.save(usuario);
    }

    public void deleteUsuario(String id) { // Eliminar un usuario
        repo.deleteById(id);
    }

    public List<Usuario> getAllUsuarios() { // Obtener todos los usuarios
       return repo.findAll();
    }

}
