package com.sample.server.controller;

import com.sample.server.model.Login;
import com.sample.server.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/security")
@Tag(name = "Security Controller", description = "Handle security actions")
public class SecurityController {

    private final UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
        summary = "Request login",
        description = "" +
            "Returns a Bearer token if login is successful, null otherwise"
    )
    @PostMapping("/login")
    public ResponseEntity authenticateUser(@RequestBody Login login) {
        String token = userService.login(login);
        return new ResponseEntity(token, HttpStatus.OK);
    }
}
