package pl.blog.spring.camel.camel.dao;

import pl.blog.spring.camel.model.Guardian;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
