package com.gymparadise.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymparadise.modelo.Usuario;

/**
 * Repositorio de datos para la entidad Usuario en una aplicación Spring Boot.
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    /**
     * Recupera un usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del usuario a buscar.
     * @return El usuario encontrado o null si no se encuentra ningún usuario con el correo electrónico dado.
     */
    public Usuario findByEmail(String email);
}