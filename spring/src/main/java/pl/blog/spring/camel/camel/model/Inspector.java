package pl.blog.spring.camel.camel.model;

import java.util.List;

public class Inspector {
    private Long id;
    private String name;
    private List<Camel> camelsToInspect;

    public Inspector(String name, List<Camel> camelsToInspect) {
        this.name = name;
        this.camelsToInspect = camelsToInspect;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Inspector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", camelsToInspect=" + camelsToInspect +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Camel> getCamelsToInspect() {
        return camelsToInspect;
    }
}
