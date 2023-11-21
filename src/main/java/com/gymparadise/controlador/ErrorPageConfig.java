package com.gymparadise.controlador;


import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;

/**
 * Clase de configuración para la gestión de páginas de error personalizadas en Spring Boot.
 */
@Configuration
public class ErrorPageConfig implements WebMvcConfigurer {

    /**
     * Configura la vista de error 404.
     *
     * @param registry El registro de controladores de vistas.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error404").setViewName("error404");
    }

    /**
     * Crea un resolvedor de vista personalizado para errores HTTP 404.
     *
     * @return Un resolvedor de vista personalizado para errores HTTP 404.
     */
    @Bean
    public ErrorViewResolver customErrorViewResolver() {
        final ErrorViewResolver resolver = (request, status, model) -> {
            if (status == HttpStatus.NOT_FOUND) {
                return new ModelAndView("error404");
            }
            return null;
        };
        return resolver;
    }

    /**
     * Crea un resolvedor de vista personalizado para errores HTTP 400 (Solicitud incorrecta).
     *
     * @return Un resolvedor de vista personalizado para errores HTTP 400.
     */
    @Bean
    public ErrorViewResolver customErrorViewResolver400() {
        final ErrorViewResolver resolver400 = (request, status, model) -> {
            if (status == HttpStatus.BAD_REQUEST) {
                return new ModelAndView("error400");
            }
            return null;
        };
        return resolver400;
    }

    /**
     * Crea un resolvedor de vista personalizado para errores HTTP 500 (Error interno del servidor).
     *
     * @return Un resolvedor de vista personalizado para errores HTTP 500.
     */
    @Bean
    public ErrorViewResolver customErrorViewResolver500() {
        final ErrorViewResolver resolver500 = (request, status, model) -> {
            if (status == HttpStatus.INTERNAL_SERVER_ERROR) {
                return new ModelAndView("error500");
            }
            return null;
        };
        return resolver500;
    }
}
