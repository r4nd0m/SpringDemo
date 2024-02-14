package com.example.SpringDemo.api;

import com.example.SpringDemo.data.Car;
import com.example.SpringDemo.data.CarRepository;
import org.springframework.data.domain.Limit;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
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

    @GetMapping({
        "/findByName/",
        "/findByName/{name}",
        "/findByName/{name}/{limit}"
    })
    public List<Car> findByName(
        @PathVariable(value = "name", required = false) String name,
        @PathVariable(value = "limit", required = false) String limit
    ) {
        name = java.util.Objects.isNull(name) ? "" : name;
        limit = java.util.Objects.isNull(limit) || Integer.parseInt(limit) <= 0 ? defaultLimit : limit;

        return this.carRepository.findByName(name, Limit.of(Integer.parseInt(limit)));
    }

    @GetMapping({
        "/findByOwner/",
        "/findByOwner/{owner}",
        "/findByOwner/{owner}/{limit}"
    })
    public List<Car> findByOwner(
        @PathVariable(value = "owner", required = false) String owner,
        @RequestParam(value = "limit", defaultValue = defaultLimit) String limit
    ) {
        owner = java.util.Objects.isNull(owner) ? "" : owner;
        limit = java.util.Objects.isNull(limit) || Integer.parseInt(limit) <= 0 ? defaultLimit : limit;

        return this.carRepository.findByOwner(owner, Limit.of(Integer.parseInt(limit)));
    }

}