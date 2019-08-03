package pl.blog.spring.camel.camel.dao;

import org.springframework.stereotype.Component;
import pl.blog.spring.camel.camel.model.Guardian;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class GuardianDao {
    private static final Map<Long, Guardian> guardians = new HashMap<>();
    private static Long GUARDIAN_ID = 0L;

    public Guardian saveGuardian(Guardian guardian) {
        guardian.setId(GUARDIAN_ID);
        guardians.put(GUARDIAN_ID, guardian);

        GUARDIAN_ID += 1;

        return guardian;
    }

    public List<Guardian> getGuardians() {
        return new LinkedList<>(guardians.values());
    }
}
