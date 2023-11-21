package com.gymparadise.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gymparadise.controlador.dto.UsuarioRegistroDTO;
import com.gymparadise.modelo.Usuario;


/**
 * Interfaz que define los métodos para gestionar usuarios en una aplicación Spring Boot.
 */
public interface UsuarioServicio extends UserDetailsService {

    /**
     * Guarda un nuevo usuario utilizando los datos proporcionados en un objeto de DTO.
     *
     * @param registroDTO El objeto DTO que contiene los datos del usuario a registrar.
     * @return El usuario registrado.
     */
    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    /**
     * Obtiene una lista de todos los usuarios registrados.
     *
     * @return Una lista de usuarios.
     */
    public List<Usuario> listarUsuarios();

    /**
     * Verifica si ya existe un usuario con la dirección de correo electrónico proporcionada.
     *
     * @param email La dirección de correo electrónico a verificar.
     * @return `true` si ya existe un usuario con el correo electrónico dado, `false` en caso contrario.
     */
    public boolean existeUsuarioConEmail(String email);
}