package com.gymparadise.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gymparadise.modelo.RegistroPeso;
import com.gymparadise.modelo.Usuario;
import com.gymparadise.repositorio.RegistroPesoRepositorio;
import com.gymparadise.repositorio.UsuarioRepositorio;

import java.security.Principal;
import java.util.List;

/**
 * Controlador para gestionar la funcionalidad relacionada con el registro de pesos en una aplicación Spring Boot.
 */
@Controller
@RequestMapping("/peso")
public class RegistroPesoControlador {

    @Autowired
    private RegistroPesoRepositorio registroPesoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    /**
     * Maneja la solicitud para listar los registros de peso del usuario actual.
     *
     * @param model     El modelo utilizado para agregar los registros de peso.
     * @param principal El objeto que representa al usuario autenticado.
     * @return La vista "lista-registros".
     */
    @GetMapping("/")
    public String listarRegistros(Model model, Principal principal) {
        String username = principal.getName();
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        List<RegistroPeso> registros = registroPesoRepositorio.findByUsuario(usuario);
        model.addAttribute("registros", registros);
        return "lista-registros";
    }

    /**
     * Maneja la solicitud para mostrar el formulario de creación de un nuevo registro de peso.
     *
     * @param model El modelo utilizado para agregar un nuevo objeto RegistroPeso.
     * @return La vista "formulario-registro".
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("registroPeso", new RegistroPeso());
        return "formulario-registro";
    }

    /**
     * Maneja la solicitud para mostrar el formulario de edición de un registro de peso existente.
     *
     * @param id    El ID del registro de peso a editar.
     * @param model El modelo utilizado para agregar el registro de peso existente.
     * @return La vista "formulario-registro".
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        RegistroPeso registroPeso = registroPesoRepositorio.findById(id).orElse(null);
        model.addAttribute("registroPeso", registroPeso);
        return "formulario-registro";
    }

    /**
     * Maneja la solicitud para guardar un registro de peso, ya sea uno nuevo o editado.
     *
     * @param registroPeso El registro de peso que se va a guardar o actualizar.
     * @param principal    El objeto que representa al usuario autenticado.
     * @return La redirección a la página de lista de registros.
     */
    @PostMapping("/guardar")
    public String guardarRegistro(@ModelAttribute("registroPeso") RegistroPeso registroPeso, Principal principal) {
        String username = principal.getName();
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        registroPeso.setUsuario(usuario);
        registroPesoRepositorio.save(registroPeso);
        return "redirect:/peso/";
    }

    /**
     * Maneja la solicitud para eliminar un registro de peso.
     *
     * @param id El ID del registro de peso a eliminar.
     * @return La redirección a la página de lista de registros.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarRegistro(@PathVariable Long id) {
        registroPesoRepositorio.deleteById(id);
        return "redirect:/peso/";
    }

    /**
     * Inicializa el enlace de datos para convertir las fechas en el formato deseado.
     *
     * @param binder El enlace de datos utilizado para registrar un editor personalizado de fechas.
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}