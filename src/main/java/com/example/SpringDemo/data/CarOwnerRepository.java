package com.example.SpringDemo.data;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface CarOwnerRepository extends CrudRepository<CarOwner, Long> {
    List<CarOwner> dummyData = List.of(
        new CarOwner("John"),
        new CarOwner("Jane"),
        new CarOwner("Giorgia"),
        new CarOwner("Carl")
    );

    @Query("SELECT c FROM CarOwner c WHERE c.name LIKE %:name% ORDER BY c.name ASC")
    List<Car> findByName(@Param("name") String name, Limit limit);

    default List<CarOwner> initializeWithDummyData() {
        if(count() == 0) {
            saveAll(dummyData);
        }

        List<CarOwner> result = new ArrayList<>();
        findAll().forEach(result::add);

        return result;
    }
}
