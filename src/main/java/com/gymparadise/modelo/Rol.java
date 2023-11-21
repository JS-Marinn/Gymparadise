package com.gymparadise.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa un rol de usuario en una aplicación Spring Boot.
 */
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    /**
     * Obtiene el ID del rol.
     *
     * @return El ID del rol.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del rol.
     *
     * @param id El ID del rol.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del rol.
     *
     * @return El nombre del rol.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del rol.
     *
     * @param nombre El nombre del rol.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor con parámetros que recibe un ID y un nombre de rol.
     *
     * @param id     El ID del rol.
     * @param nombre El nombre del rol.
     */
    public Rol(Long id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructor sin parámetros.
     */
    public Rol() {
    }

    /**
     * Constructor que recibe solo el nombre del rol.
     *
     * @param nombre El nombre del rol.
     */
    public Rol(String nombre) {
        super();
        this.nombre = nombre;
    }
}