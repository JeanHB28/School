package com.School.app.domain.repository;

import com.School.app.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseRepositoryUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByEmail(String email);
}
