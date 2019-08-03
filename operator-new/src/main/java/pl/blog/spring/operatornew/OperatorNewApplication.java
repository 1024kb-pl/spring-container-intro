package pl.blog.spring.operatornew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class OperatorNewApplication implements CommandLineRunner {
    private final Logger logger = Logger.getLogger(OperatorNewApplication.class.getName());
    private final static List<String> users = new LinkedList<>();
    private final ApplicationContext applicationContext;

    @Autowired
    public OperatorNewApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Component
    private class UserService {
        @Autowired
        private UserValidator userValidator;

        public UserService() {
        }

        private void addUser(String login) {
            userValidator.validate(login);

            users.add(login);
        }
    }

    @Component
    private class UserValidator {
        private void validate(String login) {
            logger.info("Validating user: " + login);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        // works fine, UserValidator is injected
        applicationContext.getBean(UserService.class).addUser("Mario");

        // cause NullPointerException, due to Spring can't inject UserValidator when you try to instance bean with operator new
        new UserService().addUser("Pablo");
    }




    public static void main(String[] args) {
        SpringApplication.run(OperatorNewApplication.class, args);
    }

}
