package com.example.homework2.domain.entities;

import com.example.homework2.domain.value_object.HealthStatus;
import com.example.homework2.domain.value_object.Sex;
import com.example.homework2.domain.value_object.Food;
import com.example.homework2.domain.value_object.Specie;

public class Animal {
    private String name;
    private Specie species;
    private Sex sex;
    private HealthStatus healthStatus;
    private Food favouriteFood;
    private Enclosure enclosure;
    
    public Animal(String name, Specie species, Sex sex, HealthStatus healthStatus, Food favouriteFood, Enclosure enclosure) {
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.healthStatus = healthStatus;
        this.favouriteFood = favouriteFood;
        this.enclosure = enclosure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specie getSpecies() {
        return species;
    }

    public void setSpecies(Specie species) {
        this.species = species;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Food getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(Food favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public void feed(Food f) {
    }

    public void heal() {
    }

    public String get_string() {
        String ret = "";
        ret += name;
        ret += ", the ";
        ret += species.get_string();
        ret += ", ";
        ret += sex.get();
        ret += ", ";
        ret += healthStatus.get();

        return ret;
    }

}
