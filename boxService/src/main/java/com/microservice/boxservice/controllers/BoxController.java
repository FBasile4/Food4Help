package com.microservice.boxservice.controllers;

import com.microservice.boxservice.models.Box;
import com.microservice.boxservice.repositories.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/boxms")
public class BoxController {

    @Autowired
    BoxRepository repository;

    @PostMapping(value = "/createBox")
    public Box postCharity(@RequestBody Box box) {
        System.out.println(box.getDescription());
        Box _box = repository.save(new Box(box.getId(), box.getType(), box.getDescription(), box.getWeight(), box.isAvailable(), box.getOwner()));
        return _box;
    }

    @GetMapping("/boxes")
    public List<Box> getAllBoxes() {
        System.out.println("Get all Boxes ...");

        List<Box> boxies = new ArrayList<>();
        repository.findAll().forEach(boxies::add);

        return boxies;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCharity(@PathVariable("id") long id) {
        System.out.println("Delete box with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Box has been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "boxes/available/{owner}")
    public List<Box> findByowener(@PathVariable String owner) {

        List<Box> boxes = repository.findByOwner(owner);

        for (Box b : boxes) {
            if(!b.getOwner().equals(owner))
                boxes.remove(b);
        }

        return boxes;
    }

    @GetMapping(value = "/description/{id}")
    public String boxDescriptionByID(@PathVariable long id) {

        Box box = repository.findBoxById(id);
        return box.getDescription();
    }

}

