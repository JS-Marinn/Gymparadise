package com.gymparadise.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gymparadise.controlador.dto.UsuarioRegistroDTO;
import com.gymparadise.servicio.UsuarioServicio;

/**
 * Controlador para gestionar el registro de usuarios en una aplicación Spring Boot.
 */
@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioServicio usuarioServicio;

    /**
     * Constructor que recibe el servicio de usuario.
     *
     * @param usuarioServicio El servicio utilizado para gestionar el registro de usuarios.
     */
    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    /**
     * Devuelve un nuevo objeto de DTO (Data Transfer Object) para el registro de usuario como atributo del modelo.
     *
     * @return Un objeto de DTO para el registro de usuario.
     */
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    /**
     * Maneja la solicitud para mostrar el formulario de registro de usuario.
     *
     * @return La vista "registro".
     */
    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    /**
     * Maneja la solicitud para registrar una nueva cuenta de usuario.
     *
     * @param registroDTO El objeto DTO que contiene los datos del usuario a registrar.
     * @param model      El modelo utilizado para agregar mensajes de error o éxito.
     * @return La redirección a la página de registro con un mensaje de éxito o error.
     */
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO, Model model) {
        // Verifica si el correo electrónico ya está en uso
        if (usuarioServicio.existeUsuarioConEmail(registroDTO.getEmail())) {
            model.addAttribute("error", "El correo electrónico ya está en uso.");
            return "registro";
        }
        
        // Continúa con el registro si el correo electrónico es único
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }
}
