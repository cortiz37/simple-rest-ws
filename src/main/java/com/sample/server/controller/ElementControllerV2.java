package com.sample.server.controller;

import com.sample.server.model.ElementV2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/v2/elements")
public class ElementControllerV2 {

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ElementV2 element) {
        element.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok(element);
    }
}