package pl.blog.spring.camel.camel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.blog.spring.camel.camel.model.Camel;
import pl.blog.spring.camel.camel.model.Gender;
import pl.blog.spring.camel.camel.model.Guardian;
import pl.blog.spring.camel.camel.service.CamelService;
import pl.blog.spring.camel.camel.service.GuardianService;

@Component
public class CamelFacade {
    private final CamelService camelService;
    private final GuardianService guardianService;

    @Autowired
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
