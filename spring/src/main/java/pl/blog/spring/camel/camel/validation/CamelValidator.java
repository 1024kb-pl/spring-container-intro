package pl.blog.spring.camel.camel.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.blog.spring.camel.camel.dao.CamelDao;
import pl.blog.spring.camel.camel.model.Camel;

import java.util.Optional;

@Component
public class CamelValidator {
    private final CamelDao camelDao;

    @Autowired
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
