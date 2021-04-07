package com.sample.server.controller;

import com.sample.server.model.Element;
import com.sample.server.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

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
        final Optional<Element> elementById = elementService.getElementById(id);
        if(elementById.isPresent()) {
            return ResponseEntity.ok(elementById.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") String id) {
        elementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Element element) {
        Element created = elementService.create(element);
        if(created != null) {
            return ResponseEntity.created(URI.create("/elements/" + created.getId())).build();
        }
        return ResponseEntity.badRequest().build();
    }
}