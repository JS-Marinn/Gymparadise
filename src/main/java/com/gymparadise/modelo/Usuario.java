package com.gymparadise.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Clase que representa un usuario en una aplicación Spring Boot.
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> roles;

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id El ID del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellido El apellido del usuario.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password La contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la colección de roles asignados al usuario.
     *
     * @return La colección de roles asignados al usuario.
     */
    public Collection<Rol> getRoles() {
        return roles;
    }

    /**
     * Establece la colección de roles asignados al usuario.
     *
     * @param roles La colección de roles asignados al usuario.
     */
    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    /**
     * Constructor con parámetros que recibe un ID, nombre, apellido, correo electrónico, contraseña y roles.
     *
     * @param id       El ID del usuario.
     * @param nombre   El nombre del usuario.
     * @param apellido El apellido del usuario.
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @param roles    La colección de roles asignados al usuario.
     */
    public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Constructor con parámetros que recibe nombre, apellido, correo electrónico, contraseña y roles.
     *
     * @param nombre   El nombre del usuario.
     * @param apellido El apellido del usuario.
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @param roles    La colección de roles asignados al usuario.
     */
    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Constructor sin parámetros.
     */
    public Usuario() {
    }
}