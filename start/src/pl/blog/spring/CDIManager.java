package pl.blog.spring;

import pl.blog.spring.camel.CamelFacade;
import pl.blog.spring.camel.dao.CamelDao;
import pl.blog.spring.camel.dao.GuardianDao;
import pl.blog.spring.camel.service.CamelService;
import pl.blog.spring.camel.service.GuardianService;
import pl.blog.spring.camel.validation.CamelValidator;
import pl.blog.spring.camel.validation.GuardianValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CDIManager {
    private static final Map<Class, Object> objects = new HashMap<>();

    static {
        objects.put(GuardianDao.class, new GuardianDao());
        objects.put(CamelDao.class, new CamelDao());
        objects.put(GuardianValidator.class, new GuardianValidator(get(GuardianDao.class)));
        objects.put(CamelValidator.class, new CamelValidator(get(CamelDao.class)));
        objects.put(GuardianService.class, new GuardianService(get(GuardianDao.class), get(GuardianValidator.class)));
        objects.put(CamelService.class, new CamelService(get(CamelDao.class), get(CamelValidator.class)));
        objects.put(CamelFacade.class, new CamelFacade(get(CamelService.class), get(GuardianService.class)));
    }

    public static <T> T get(Class<T> name) {
        return Optional.ofNullable(objects.get(name))
                .map(name::cast)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find implementation for: " + name + " class."));
    }
}
