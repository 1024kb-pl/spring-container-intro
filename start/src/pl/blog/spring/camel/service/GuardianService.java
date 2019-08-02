package pl.blog.spring.camel.service;

import pl.blog.spring.camel.model.Guardian;
import pl.blog.spring.camel.validation.GuardianValidator;
import pl.blog.spring.camel.dao.GuardianDao;

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
