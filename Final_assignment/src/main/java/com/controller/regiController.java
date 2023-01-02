package com.controller;

import com.domain.User;
import com.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/user")
public class regiController {

    private UserService userService;

    public regiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")

    public ResponseEntity<User> register(@Valid @RequestBody User user) throws URISyntaxException {
        User newUser = userService.insert(user);
        return ResponseEntity.created(new URI("/register"))
                .body(null);
    }

}
