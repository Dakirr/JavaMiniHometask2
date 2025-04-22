package com.example.homework2.domain.entities;

import java.util.ArrayList;
import java.util.List;

import com.example.homework2.domain.value_object.AnimalType;

public class Enclosure {
    private AnimalType type;
    private List<Animal> animals = new ArrayList<>();
    private int size;
    private int current_animals_number;
    private int max_animals_number;

    public Enclosure(AnimalType type, int size, int max_animals_number) {
        this.type = type;
        this.size = size;
        this.max_animals_number = max_animals_number;
        this.current_animals_number = 0;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent_animals_number() {
        return current_animals_number;
    }

    public void setCurrent_animals_number(int current_animals_number) {
        this.current_animals_number = current_animals_number;
    }

    public int getMax_animals_number() {
        return max_animals_number;
    }

    public void setMax_animals_number(int max_animals_number) {
        this.max_animals_number = max_animals_number;
    }

    public void add_animal(Animal animal) {
        animals.add(animal);
        current_animals_number++;
    }

    public void remove_animal(Animal animal) {
        animals.remove(animal);
        current_animals_number--;
    }

    public void clean() {

    }

    public String get_string() {
        String ret = "Enclosure: ";
        ret += type.get_string();
        ret += ", ";
        ret += size;
        ret += ", ";
        ret += current_animals_number;
        ret += "/";
        ret += max_animals_number;
        ret += "\n";
        ret += "{";
        for (Animal a : animals) {
            ret += a.get_string();
            ret += ",\n";
        }
        ret += "}\n\n";
        return ret;
    }

}
