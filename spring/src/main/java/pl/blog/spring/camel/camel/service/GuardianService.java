package pl.blog.spring.camel.camel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.blog.spring.camel.camel.dao.GuardianDao;
import pl.blog.spring.camel.camel.model.Guardian;
import pl.blog.spring.camel.camel.validation.GuardianValidator;

@Component
public class GuardianService {
    private final GuardianDao guardianDao;
    private final GuardianValidator guardianValidator;

    @Autowired
    public GuardianService(GuardianDao guardianDao, GuardianValidator guardianValidator) {
        this.guardianDao = guardianDao;
        this.guardianValidator = guardianValidator;
    }

    public Guardian addGuardian(Guardian guardian) {
        guardianValidator.validate(guardian);

        return guardianDao.saveGuardian(guardian);
    }
}
