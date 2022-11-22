package com.School.app.config;

import com.School.app.domain.entity.Usuario;
import com.School.app.domain.repository.BaseRepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServicelmpl implements UserDetailsService {

    @Autowired
    private BaseRepositoryUsuario baseRepositoryUsuario;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = baseRepositoryUsuario
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email" + email + " no existe."));
        return new UserDetailsImpl(usuario);
    }
}
