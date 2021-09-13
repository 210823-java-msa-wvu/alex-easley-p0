package dev.easley.models;

public class Supplies {

    private Integer citizen_id;
    private String resources;
    private Integer resource_amount;

    public Supplies() {
    }

    public Supplies(String resources, Integer resource_amount) {
        this.resources = resources;
        this.resource_amount = resource_amount;
    }

    public Supplies(String resources, Integer resource_amount, Integer citizen_id) {
        this.citizen_id = citizen_id;
        this.resources = resources;
        this.resource_amount = resource_amount;
    }

    public Integer getCitizen_id() {
        return citizen_id;
    }

    public void setCitizen_id(Integer citizen_id) {
        this.citizen_id = citizen_id;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Integer getResource_amount() {
        return resource_amount;
    }

    public void setResource_amount(Integer resource_amount) {
        this.resource_amount = resource_amount;
    }

    @Override
    public String toString() {
        return "Supplies{" +
                "citizen_id=" + citizen_id +
                ", resources='" + resources + '\'' +
                ", resource_amount=" + resource_amount +
                '}';
    }
}

