package pl.blog.spring.camel.camel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.blog.spring.camel.camel.dao.InspectorDao;
import pl.blog.spring.camel.camel.model.Camel;
import pl.blog.spring.camel.camel.model.Inspector;
import pl.blog.spring.camel.camel.validation.InspectorValidator;

@Component
public class InspectorService {
    private final InspectorDao inspectorDao;
    private final InspectorValidator inspectorValidator;

    @Autowired
    public InspectorService(InspectorDao inspectorDao, InspectorValidator inspectorValidator) {
        this.inspectorDao = inspectorDao;
        this.inspectorValidator = inspectorValidator;
    }


    public Inspector addInspector(Inspector inspector) {
        inspectorValidator.validate(inspector);

        return inspectorDao.saveInspector(inspector);
    }
}
