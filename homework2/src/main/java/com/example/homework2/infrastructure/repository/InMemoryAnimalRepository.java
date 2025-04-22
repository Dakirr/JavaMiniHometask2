package com.example.homework2.application.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Repository;

import com.example.homework2.application.repository.AnimalRepository;
import com.example.homework2.domain.entities.Animal;

@Repository
public class InMemoryAnimalRepository implements AnimalRepository{
    int cur_id = 0;
    private Map<Integer, Animal> animals;
    
    public InMemoryAnimalRepository() {
        animals = new HashMap<>();
    }

    public int addAnimal(Animal animal) {
        int tmp = cur_id;
        cur_id++;
        Integer I = tmp;
        animals.put(I, animal);
        return tmp;
    }

    public Animal getAnimal(int id) {
        Integer I = id;
        return animals.get(I);
    }

    public List<Animal> getAnimals(Function<Animal, Boolean> filter) {
        List<Animal> ret = new ArrayList<>();
        Set<Integer> keys = animals.keySet();
        for (Integer I : keys) {
            if (filter.apply(animals.get(I))) {
                ret.add(animals.get(I));
            }
        }
        return ret;
    }

    public void removeAnimal(int id) {
        Integer I = id;
        animals.remove(I);
    }
    
}

