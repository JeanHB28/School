package com.School.app.service;

import com.School.app.config.WebSecurityConfig;
import com.School.app.domain.entity.Usuario;
import com.School.app.domain.repository.BaseRepositoryUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService<Usuario> {
    private final BaseRepositoryUsuario baseRepositoryUsuario;


    public UserServiceImpl(BaseRepositoryUsuario baseRepositoryUsuario, WebSecurityConfig webSecurityConfig) {
        this.baseRepositoryUsuario = baseRepositoryUsuario;

    }

    @Override
    public boolean save(Usuario entity) {
        Usuario user = Usuario.builder()
                .password(new BCryptPasswordEncoder().encode(entity.getPassword()))
                .email(entity.getEmail())
                .nombre(entity.getNombre())
                .build();
        baseRepositoryUsuario.save(user);

        return true;
    }

    @Override
    public Usuario finByEmail(String email) {
        return null;
    }
}
