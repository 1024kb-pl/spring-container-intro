package pl.blog.spring.camel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.blog.spring.camel.camel.CamelFacade;
import pl.blog.spring.camel.camel.model.Camel;
import pl.blog.spring.camel.camel.model.Gender;
import pl.blog.spring.camel.camel.model.Guardian;

@SpringBootApplication
public class CamelApplication implements CommandLineRunner {
	private final ApplicationContext applicationContext;

	@Autowired
	public CamelApplication(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static void main(String[] args) {
		SpringApplication.run(CamelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CamelFacade camelFacade = applicationContext.getBean(CamelFacade.class);
		Camel camel = camelFacade.createCamel(new Guardian("Jan", "jan@mail.com", "admin"), "Mela", 15, Gender.FEMALE);

		System.out.println(camel);
	}
}
