package pl.blog.spring.camel.service;

import pl.blog.spring.camel.dao.CamelDao;
import pl.blog.spring.camel.model.Camel;
import pl.blog.spring.camel.validation.CamelValidator;

public class CamelService {
    private final CamelDao camelDao;
    private final CamelValidator camelValidator;

    public CamelService(CamelDao camelDao, CamelValidator camelValidator) {
        this.camelDao = camelDao;
        this.camelValidator = camelValidator;
    }

    public Camel addCamel(Camel camel) {
        camelValidator.validate(camel);

        return camelDao.saveCamel(camel);
    }
}
