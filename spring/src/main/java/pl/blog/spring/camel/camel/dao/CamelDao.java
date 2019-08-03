package pl.blog.spring.camel.camel.dao;

import org.springframework.stereotype.Component;
import pl.blog.spring.camel.camel.model.Camel;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CamelDao {
    private static final Map<Long, Camel> camels = new HashMap<>();
    private static Long CAMEL_ID = 0L;

    public Camel saveCamel(Camel camel) {
        camel.setId(CAMEL_ID);
        camels.put(CAMEL_ID, camel);

        CAMEL_ID += 1;

        return camel;
    }

    public Optional<Camel> getCamelByName(String name) {
        return camels.values().stream()
                .filter(camel -> camel.getName().equals(name))
                .findFirst();
    }
}
