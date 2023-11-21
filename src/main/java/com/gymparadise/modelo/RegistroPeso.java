package com.gymparadise.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Date;

/**
 * Clase que representa un registro de peso en una aplicación Spring Boot.
 */
@Entity
public class RegistroPeso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double peso;
    private Date fecha;

    @ManyToOne
    private Usuario usuario; // Relación Many-to-One con Usuario

    /**
     * Obtiene el ID del registro de peso.
     *
     * @return El ID del registro de peso.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del registro de peso.
     *
     * @param id El ID del registro de peso.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el peso registrado.
     *
     * @return El peso registrado.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso registrado.
     *
     * @param peso El peso registrado.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene la fecha en la que se registró el peso.
     *
     * @return La fecha de registro del peso.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se registró el peso.
     *
     * @param fecha La fecha de registro del peso.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el usuario al que se asocia el registro de peso.
     *
     * @return El usuario asociado al registro de peso.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario al que se asocia el registro de peso.
     *
     * @param usuario El usuario asociado al registro de peso.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}