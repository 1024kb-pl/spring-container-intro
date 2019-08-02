package pl.blog.spring.camel.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Camel {
    private Long id;
    private String name;
    private int age;
    private Gender gender;
    private List<Guardian> guardians;


    public Camel(String name, int age, Gender gender, Guardian guardian) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        guardians = new LinkedList<>(Collections.singleton(guardian));
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Guardian> getGuardians() {
        return guardians;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Camel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", guardians=" + guardians +
                '}';
    }
}
