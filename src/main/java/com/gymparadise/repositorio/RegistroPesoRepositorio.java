package com.gymparadise.repositorio;

import com.gymparadise.modelo.RegistroPeso;
import com.gymparadise.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio de datos para la entidad RegistroPeso en una aplicación Spring Boot.
 */
@Repository
public interface RegistroPesoRepositorio extends JpaRepository<RegistroPeso, Long> {

    /**
     * Recupera una lista de registros de peso asociados a un usuario específico.
     *
     * @param usuario El usuario para el que se desean recuperar los registros de peso.
     * @return Una lista de registros de peso asociados al usuario.
     */
    List<RegistroPeso> findByUsuario(Usuario usuario);
}