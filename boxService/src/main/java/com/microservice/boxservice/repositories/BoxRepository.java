package com.microservice.boxservice.repositories;

import com.microservice.boxservice.models.Box;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BoxRepository extends CrudRepository<Box, Long> {
    //List<Box> findById (long id);
    List<Box> findByOwner(String owner);
    Box findBoxById(long id);
    List<Box> findByOwnerIs(String owner);

}
