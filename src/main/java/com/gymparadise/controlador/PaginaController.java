package com.gymparadise.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para gestionar las páginas en una aplicación Spring Boot.
 */
@Controller
public class PaginaController {

    /**
     * Maneja la solicitud para mostrar la página "tmb".
     *
     * @return La vista "tmb".
     */
    @GetMapping("/tmb")
    public String mostrarTMB() {
        return "tmb";
    }

    /**
     * Maneja la solicitud para mostrar la página "rmcalculator".
     *
     * @return La vista "rmcalculator".
     */
    @GetMapping("/rmcalculator")
    public String mostrarRMCalculator() {
        return "rmcalculator";
    }

    /**
     * Maneja la solicitud para mostrar la página de error 404.
     *
     * @return La vista "error404".
     */
    @GetMapping("/error404")
    public String mostrar404() {
        return "error404";
    }

    /**
     * Maneja la solicitud para mostrar la página de error 400 (Solicitud incorrecta).
     *
     * @return La vista "error400".
     */
    @GetMapping("/error400")
    public String mostrar400() {
        return "error400";
    }

    /**
     * Maneja la solicitud para mostrar la página de error 500 (Error interno del servidor).
     *
     * @return La vista "error500".
     */
    @GetMapping("/error500")
    public String mostrar500() {
        return "error500";
    }
}
