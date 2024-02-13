package com.example.SpringDemo.Data;

import jakarta.persistence.*;

@Entity
public class CarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 1000)
    private String name;

    public CarOwner() {}

    public CarOwner(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "CarOwner{ id: " + getId() + ", + name: " + getName() +" }";
    }

}
