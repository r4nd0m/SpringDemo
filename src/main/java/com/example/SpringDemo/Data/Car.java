package com.example.SpringDemo.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.StringJoiner;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 1000)
    private String name;
    @Column(length = 1000)
    private String owner;

    public Car() {

    }

    public Car(String name, String owner) {
        super();
        this.name = name;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Car{ name: " + this.name + ", owner: " + this.owner + " }";
    }

}
