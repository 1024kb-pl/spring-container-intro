package pl.blog.spring;

import pl.blog.spring.camel.CamelFacade;
import pl.blog.spring.camel.dao.CamelDao;
import pl.blog.spring.camel.dao.GuardianDao;
import pl.blog.spring.camel.service.CamelService;
import pl.blog.spring.camel.service.GuardianService;
import pl.blog.spring.camel.validation.CamelValidator;
import pl.blog.spring.camel.validation.GuardianValidator;

public class CamelMain {
    public static CamelFacade createCamelFacade() {
        CamelDao camelDao = new CamelDao();
        GuardianDao guardianDao = new GuardianDao();

        CamelValidator camelValidator = new CamelValidator(camelDao);
        GuardianValidator guardianValidator = new GuardianValidator(guardianDao);

        CamelService camelService = new CamelService(camelDao, camelValidator);
        GuardianService guardianService = new GuardianService(guardianDao, guardianValidator);

        return new CamelFacade(camelService, guardianService);
    }

    public static void main(String[] args) {
        CamelFacade camelFacade = createCamelFacade();
    }
}
