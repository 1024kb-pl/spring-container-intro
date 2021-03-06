package pl.blog.spring.camel.validation;

import pl.blog.spring.camel.dao.GuardianDao;
import pl.blog.spring.camel.model.Guardian;

public class GuardianValidator {
    private final GuardianDao guardianDao;

    public GuardianValidator(GuardianDao guardianDao) {
        this.guardianDao = guardianDao;
    }

    public void validate(Guardian guardian) {
        if (isEmailTaken(guardian.getEmail())) {
            throw new RuntimeException("Email: " + guardian.getEmail() + " is already taken.");
        }

        String fullName = buildFullName(guardian);
        if (isGuardianExists(fullName)) {
            throw new RuntimeException("Guardian: " + fullName + " already exists.");
        }
    }

    private boolean isEmailTaken(String email) {
        return guardianDao.getGuardians().stream()
                .map(Guardian::getEmail)
                .anyMatch(e -> e.equals(email));
    }

    private boolean isGuardianExists(String fullName) {
        return guardianDao.getGuardians().stream()
                .map(this::buildFullName)
                .anyMatch(l -> l.equals(fullName));
    }

    private String buildFullName(Guardian guardian) {
        return guardian.getName() + " " + guardian.getLastName();
    }
}
