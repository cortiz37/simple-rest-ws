package com.sample.server.service;

import com.sample.server.model.Element;
import com.sample.server.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementService {

    private final ElementRepository elementRepository;

    @Autowired
    public ElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public List<Element> getAll() {
        return elementRepository.getDatabase();
    }
}