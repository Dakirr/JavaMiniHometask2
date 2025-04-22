package com.example.homework2.domain.entities;

import com.example.homework2.domain.value_object.Food;
import com.example.homework2.domain.value_object.Time;

public class FeedingSchedule {
    Animal animal;
    Time time;
    Food food;
    Boolean isActual = true;


    public FeedingSchedule(Animal animal, Time time, Food food) {
        this.animal = animal;
        this.time = time;
        this.food = food;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
    
    public void cancel() {
        isActual = false;
    }

    public Boolean getIsActual() {
        return isActual;
    }

}
