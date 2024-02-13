package com.example.SpringDemo.Data;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 1000)
    private String name;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner")
    @Nullable
    private CarOwner owner;

    public Car() {}

    public Car(String name) {
        super();
        this.name = name;
    }

    public Car(String name, @Nullable CarOwner owner) {
        super();
        this.name = name;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    @Nullable
    public CarOwner getOwner() {
        return owner;
    }

    public void setOwner(@Nullable CarOwner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Car{ id: " + getId() + ", + name: " + getName() + ", owner: " + getOwner() + " }";
    }

}
