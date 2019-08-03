package pl.blog.spring.camel.camel.validation;

import pl.blog.spring.camel.dao.CamelDao;
import pl.blog.spring.camel.model.Camel;

import java.util.Optional;

public class CamelValidator {
    private final CamelDao camelDao;

    public CamelValidator(CamelDao camelDao) {
        this.camelDao = camelDao;
    }

    public void validate(Camel camel) {
        String name = camel.getName();
        Optional<Camel> optionalCamel = camelDao.getCamelByName(name);

        if (optionalCamel.isPresent()) {
            throw new RuntimeException("Camel with name: " + name + " already exists.");
        }
    }
}
