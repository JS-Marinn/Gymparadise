package com.gymparadise.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gymparadise.servicio.UsuarioServicio;

/**
 * Controlador para gestionar la funcionalidad relacionada con el registro y la visualización de usuarios en una aplicación Spring Boot.
 */
@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio servicio;

    /**
     * Maneja la solicitud para mostrar la página de inicio de sesión.
     *
     * @return La vista "login".
     */
    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    /**
     * Maneja la solicitud para mostrar la página de inicio y visualizar una lista de usuarios.
     *
     * @param modelo El modelo que se utiliza para agregar la lista de usuarios.
     * @return La vista "inicio".
     */
    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "inicio";
    }
}
