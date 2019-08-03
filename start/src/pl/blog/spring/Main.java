package pl.blog.spring;

import pl.blog.spring.camel.CamelFacade;
import pl.blog.spring.camel.model.Camel;
import pl.blog.spring.camel.model.Gender;
import pl.blog.spring.camel.model.Guardian;

public class Main {

    public static void main(String[] args) {
        CamelFacade camelFacade = CDIManager.get(CamelFacade.class);

        Camel camel = camelFacade.createCamel(new Guardian("Jan", "jan@mail.com", "admin"), "Mela", 15, Gender.FEMALE);

        System.out.println(camel);

//        Guardian guardian = CDIManager.get(Guardian.class);
        Guardian guardian = CDIManager.getFreshInstance(Guardian.class);
    }
}
