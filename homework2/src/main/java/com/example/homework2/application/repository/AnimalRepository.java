package com.example.homework2.application.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Repository;

import com.example.homework2.domain.entities.Animal;

@Repository
public interface AnimalRepository {    
    public int addAnimal(Animal animal);
    public Animal getAnimal(int id);
    public List<Animal> getAnimals(Function<Animal, Boolean> filter);
    public void removeAnimal(int id);
    
}

