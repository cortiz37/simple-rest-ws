package com.sample.server.repository;

import com.sample.server.model.Element;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * In memory 'database'
 */
@Repository
public class ElementRepository {

    private final static List<Element> database = new ArrayList<>();

    static {
        database.add(new Element("default-e1", "Element 1", "Lorem ipsum dolor sit amet", new Date(), true, 5));
        database.add(new Element("default-e2", "Element 2", "Ut enim ad minim veniam", new Date(), false, 0));
        database.add(new Element("default-e3", "Element 3", "Excepteur sint occaecat cupidatat non proident,", new Date(), true, 15));
    }

    public Element save(Element element) {
        database.add(element);
        return element;
    }

    public Optional<Element> getById(String id) {
        return Optional.empty();
    }

    public boolean delete(String id) {
        return false;
    }

    public List<Element> getDatabase() {
        return database;
    }
}