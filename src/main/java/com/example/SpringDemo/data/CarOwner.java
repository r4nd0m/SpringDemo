package com.example.SpringDemo.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1000)
    private String name;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
    private List<Car> cars;

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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String toString() {
        return "CarOwner{ id: " + getId() + ", + name: " + getName() + ", cars: "+getCars().toString()+" }";
    }

}
