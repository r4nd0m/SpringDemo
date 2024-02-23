package com.example.SpringDemo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface ApiUserRepository extends CrudRepository<ApiUser, Long> {
    Optional<ApiUser> findByUsername(String username);

    default void initializeWithDummyData(List<ApiUser> dummyData) {
        if(count() == 0) {
            saveAll(dummyData);
        }
    }
}
