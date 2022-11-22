package com.School.app.controller;
import com.School.app.domain.entity.Usuario;
import com.School.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/signup")
public class UserController {

    private final UserService<Usuario> userService;

    @PostMapping(value = "/save")
    public void save(@RequestBody Usuario Usuario) {
        userService.save(Usuario);
    }
}
