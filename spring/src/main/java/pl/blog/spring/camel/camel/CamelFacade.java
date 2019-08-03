package pl.blog.spring.camel.camel;

import pl.blog.spring.camel.model.Camel;
import pl.blog.spring.camel.model.Gender;
import pl.blog.spring.camel.model.Guardian;
import pl.blog.spring.camel.service.CamelService;
import pl.blog.spring.camel.service.GuardianService;

public class CamelFacade {
    private final CamelService camelService;
    private final GuardianService guardianService;

    public CamelFacade(CamelService camelService, GuardianService guardianService) {
        this.camelService = camelService;
        this.guardianService = guardianService;
    }

    public Camel createCamel(Guardian guardian, String camelName, int age, Gender gender) {
        Guardian camelGuardian = guardianService.addGuardian(guardian);

        Camel camel = new Camel(camelName, age, gender, camelGuardian);

        return camelService.addCamel(camel);
    }
}
