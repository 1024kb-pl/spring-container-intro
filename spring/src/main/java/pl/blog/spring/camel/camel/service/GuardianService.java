package pl.blog.spring.camel.camel.service;

import pl.blog.spring.camel.dao.GuardianDao;
import pl.blog.spring.camel.model.Guardian;
import pl.blog.spring.camel.validation.GuardianValidator;

public class GuardianService {
    private final GuardianDao guardianDao;
    private final GuardianValidator guardianValidator;

    public GuardianService(GuardianDao guardianDao, GuardianValidator guardianValidator) {
        this.guardianDao = guardianDao;
        this.guardianValidator = guardianValidator;
    }

    public Guardian addGuardian(Guardian guardian) {
        guardianValidator.validate(guardian);

        return guardianDao.saveGuardian(guardian);
    }
}
