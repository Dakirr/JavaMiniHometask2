package com.example.homework2.domain.value_object;

public class Specie {
    private String name;
    private AnimalType type;

    public Specie(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_string() {
        return name + " (" + type.get_string() + ")";
    }
}
