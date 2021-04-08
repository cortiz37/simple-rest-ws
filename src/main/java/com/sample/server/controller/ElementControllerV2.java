package com.sample.server.controller;

import com.sample.server.model.ElementV2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/v2/elements")
@Tag(name = "Element Controller (v2)", description = "The new version of Element API with improved functions")
public class ElementControllerV2 {

    @GetMapping
    @Operation(
        summary = "Get all elements",
        description = "" +
            "Returns all elements from the database.<br><br>" +
            "<b>Important</b>: Not implemented yet!"
    )
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping
    @Operation(
        summary = "Create an element",
        description = "" +
            "Insert new element into the database.<br><br>" +
            "<b>Important</b>: Not implemented yet!",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            description = "JSON document representing the `element` entity (v2)",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                examples = @ExampleObject(name = "map", value = "" +
                    "{\n" +
                    "  \"index\": \"Sales\",\n" +
                    "  \"total\": 60.75\n" +
                    "}")
            )
        )
    )
    public ResponseEntity create(@RequestBody ElementV2 element) {
        element.setId(UUID.randomUUID().toString());
        element.setDate(element.getDate() != null ? element.getDate() : new Date());
        return ResponseEntity.ok(element);
    }
}