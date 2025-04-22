package com.example.homework2.presentation;

import com.example.homework2.application.service.AnimalManagementService;
import com.example.homework2.domain.entities.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {
    private AnimalManagementService animalManagementService;

    public AnimalController(AnimalManagementService animalManagementService) {
        this.animalManagementService = animalManagementService;
    }
    
    @GetMapping("/api/animals")
    public ResponseEntity<List<Animal>> getAnimals() {
        List<Animal> animals = animalManagementService.getAnimals();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @GetMapping("/api/animals/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable int id) {
        Animal animal = animalManagementService.getAnimal(id);
        if (animal != null) {
            return new ResponseEntity<>(animal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/animals/{id}")
    public ResponseEntity<Integer> removeAnimal(@PathVariable int id) {
        animalManagementService.removeAnimal(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/api/animals")
    public ResponseEntity<Integer> addAnimal(@RequestBody Animal animal) {
        int Animal_id = animalManagementService.addAnimal(animal);
        return new ResponseEntity<>(Animal_id, HttpStatus.CREATED);
    }

}
    