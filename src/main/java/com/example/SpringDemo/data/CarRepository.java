package com.example.SpringDemo.data;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RepositoryRestResource(path = "cars")
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> dummyData = List.of(
        new Car("Ford"),
        new Car("KIA"),
        new Car("Toyota"),
        new Car("BMW")
    );

    @Query("SELECT c FROM Car c ORDER BY c.name ASC")
    List<Car> findAllLimited(Limit limit);

    @Query("SELECT c FROM Car c WHERE c.name LIKE %:name% ORDER BY c.name ASC")
    List<Car> findByName(@Param("name") String name, Limit limit);

    @Query("SELECT c FROM Car c JOIN FETCH c.owner co WHERE co.name LIKE %:owner%")
    List<Car> findByOwner(@Param("owner") String owner, Limit limit);

    default void initializeWithDummyData(List<CarOwner> owners) {
        if(count() == 0) {
            saveAll(
                dummyData.stream()
                    .peek(car -> car.setOwner(owners.get(new Random().nextInt(owners.size()))))
                    .collect(Collectors.toList())
            );
        }
    }
}
