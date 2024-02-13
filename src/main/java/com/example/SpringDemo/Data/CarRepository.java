package com.example.SpringDemo.Data;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> dummyData = List.of(
        new Car("Ford"),
        new Car("KIA"),
        new Car("Toyota"),
        new Car("BMW")
    );

    @Query("SELECT c FROM Car c WHERE c.name LIKE %:name% ORDER BY c.name ASC")
    List<Car> findByName(@Param("name") String name, Limit limit);

//    @Query("SELECT c FROM Car c WHERE c.owner LIKE %:owner% ORDER BY c.owner ASC")
//    List<Car> findByOwner(@Param("owner") String owner, Limit limit);
//    @Query("SELECT c FROM Car c WHERE c.name LIKE %:name% AND c.owner LIKE %:owner% ORDER BY c.name ASC, c.owner ASC")
//    List<Car> findByNameAndOwner(@Param("name") String name, @Param("owner") String owner, Limit limit);

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
