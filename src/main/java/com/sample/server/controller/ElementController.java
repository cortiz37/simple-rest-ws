package com.sample.server.controller;

import com.sample.server.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/elements")
public class ElementController {

    private final ElementService elementService;

    @Autowired
    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(elementService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") String id) {
        return ResponseEntity.badRequest().build();
    }
}