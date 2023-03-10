package com.microservice.boxservice.models;

import javax.persistence.*;

@Entity
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private int weight;

    @Column(name = "available")
    private boolean available;

    @Column(name = "owner")
    private String owner;

    public Box(long id, String type, String description, int weight, boolean available, String owner) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.weight = weight;
        this.available = available;
        this.owner = owner;
    }

    public Box(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

