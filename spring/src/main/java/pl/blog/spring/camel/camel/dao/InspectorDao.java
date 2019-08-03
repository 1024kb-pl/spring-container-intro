package pl.blog.spring.camel.camel.dao;

import org.springframework.stereotype.Component;
import pl.blog.spring.camel.camel.model.Camel;
import pl.blog.spring.camel.camel.model.Inspector;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InspectorDao {
    private static final Map<Long, Inspector> inspectors = new HashMap<>();
    private static Long INSPECTOR_ID = 0L;

    public Inspector saveInspector(Inspector inspector) {
        inspector.setId(INSPECTOR_ID);
        inspectors.put(INSPECTOR_ID, inspector);

        INSPECTOR_ID += 1;

        return inspector;
    }
}
