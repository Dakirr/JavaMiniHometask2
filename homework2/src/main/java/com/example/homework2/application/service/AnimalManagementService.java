package com.example.homework2.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.homework2.application.repository.AnimalRepository;
import com.example.homework2.domain.entities.Animal;

@Service
public class AnimalManagementService {
    AnimalRepository ar;

    public AnimalManagementService(AnimalRepository ar) {
        this.ar = ar;
    }
    public void removeAnimal(int id) {
        ar.removeAnimal(id);
    }
    
    public int addAnimal(Animal a) {
        return ar.addAnimal(a);
    }

    public Animal getAnimal(int id) {
        return ar.getAnimal(id);
    }

    public List<Animal> getAnimals() {
        return ar.getAnimals(a -> true);
    }

}