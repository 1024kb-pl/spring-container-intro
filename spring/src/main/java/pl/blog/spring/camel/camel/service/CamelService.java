package pl.blog.spring.camel.camel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.blog.spring.camel.camel.dao.CamelDao;
import pl.blog.spring.camel.camel.model.Camel;
import pl.blog.spring.camel.camel.validation.CamelValidator;

@Component
public class CamelService {
    private final CamelDao camelDao;
    private final CamelValidator camelValidator;

    @Autowired
    public CamelService(CamelDao camelDao, CamelValidator camelValidator) {
        this.camelDao = camelDao;
        this.camelValidator = camelValidator;
    }

    public Camel addCamel(Camel camel) {
        camelValidator.validate(camel);

        return camelDao.saveCamel(camel);
    }
}
