/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import crud.Interfaz_Usu;
import daos.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Puesto19
 */
    @Service
public class UsuarioService {

    @Autowired
    private Interfaz_Usu usuarioRepository;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.leerUsuario(em);
    }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        } else {
            return null; // Puedes manejar la lógica de error según tus necesidades
        }
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
