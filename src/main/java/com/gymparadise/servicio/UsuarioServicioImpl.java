package com.gymparadise.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gymparadise.controlador.dto.UsuarioRegistroDTO;
import com.gymparadise.modelo.Rol;
import com.gymparadise.modelo.Usuario;
import com.gymparadise.repositorio.UsuarioRepositorio;

/**
 * Implementación del servicio de usuarios en una aplicación Spring Boot.
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Constructor que recibe una instancia de `UsuarioRepositorio`.
     *
     * @param usuarioRepositorio El repositorio de usuarios.
     */
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        super();
        this.usuarioRepositorio = usuarioRepositorio;
    }

    /**
     * Verifica si ya existe un usuario con la dirección de correo electrónico proporcionada.
     *
     * @param email La dirección de correo electrónico a verificar.
     * @return `true` si ya existe un usuario con el correo electrónico dado, `false` en caso contrario.
     */
    public boolean existeUsuarioConEmail(String email) {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        return usuario != null;
    }

    /**
     * Registra un nuevo usuario utilizando los datos proporcionados en un objeto de DTO.
     *
     * @param registroDTO El objeto DTO que contiene los datos del usuario a registrar.
     * @return El usuario registrado.
     */
    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(), registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepositorio.save(usuario);
    }

    /**
     * Carga los detalles de un usuario por su nombre de usuario (correo electrónico).
     *
     * @param username El nombre de usuario (correo electrónico) del usuario a cargar.
     * @return Los detalles del usuario.
     * @throws UsernameNotFoundException Si no se encuentra el usuario con el nombre de usuario dado.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    /**
     * Convierte la colección de roles de usuario en una colección de autoridades de seguridad.
     *
     * @param roles La colección de roles de usuario.
     * @return La colección de autoridades de seguridad.
     */
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    /**
     * Obtiene una lista de todos los usuarios registrados.
     *
     * @return Una lista de usuarios.
     */
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
}