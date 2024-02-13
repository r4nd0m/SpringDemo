package com.example.SpringDemo;

import com.example.SpringDemo.Data.Car;
import com.example.SpringDemo.Data.CarRepository;
import org.springframework.data.domain.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    private final CarRepository carRepository;
    private static final String defaultLimit = "10";

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public List<Car> getCars(@RequestParam(value = "limit", defaultValue = defaultLimit) String limit) {
        return new ArrayList<>(
            this.carRepository.findAllLimited(
                Limit.of(
                    Integer.parseInt(limit)
                )
            )
        );
    }

    @GetMapping("/findByName")
    public List<Car> findByName(
        @RequestParam(value = "name", defaultValue = "") String name,
        @RequestParam(value = "limit", defaultValue = defaultLimit) String limit
    ) {
        return this.carRepository.findByName(name, Limit.of(Integer.parseInt(limit)));
    }

    @GetMapping("/findByOwner")
    public List<Car> findByOwner(
        @RequestParam(value = "owner", defaultValue = "") String owner,
        @RequestParam(value = "limit", defaultValue = defaultLimit) String limit
    ) {
        return this.carRepository.findByOwner(owner, Limit.of(Integer.parseInt(limit)));
    }

}