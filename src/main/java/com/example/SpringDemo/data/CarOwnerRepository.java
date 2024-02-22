package com.example.SpringDemo.data;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestResource(path = "carOwners")
public interface CarOwnerRepository extends CrudRepository<CarOwner, Long> {
    List<CarOwner> dummyData = List.of(
        new CarOwner("John"),
        new CarOwner("Jane"),
        new CarOwner("Giorgia"),
        new CarOwner("Carl")
    );

    @Query("SELECT c FROM CarOwner c WHERE c.name LIKE %:name% ORDER BY c.name ASC")
    @RestResource(exported=false)
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
