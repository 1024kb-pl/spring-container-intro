package pl.blog.spring.camel.camel.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.blog.spring.camel.camel.dao.CamelDao;
import pl.blog.spring.camel.camel.model.Camel;
import pl.blog.spring.camel.camel.model.Inspector;

import java.util.Optional;

@Component
public class InspectorValidator {
    public void validate(Inspector inspector) {
        if (inspector.getCamelsToInspect().isEmpty()) {
            throw new RuntimeException("Inspector should have any camels to inspect.");
        }
    }
}
