package com.example.homework2.domain.event;

import com.example.homework2.domain.entities.Animal;
import com.example.homework2.domain.entities.Enclosure;

public class AnimalMovedEvent {
    private Animal animal;
    private Enclosure oldEnclosure;
    private Enclosure newEnclosure;

    public AnimalMovedEvent(Animal animal, Enclosure oldEnclosure, Enclosure newEnclosure) {
        this.animal = animal;
        this.oldEnclosure = oldEnclosure;
        this.newEnclosure = newEnclosure; 
    }

    public Animal getAnimal() {
        return animal;
    }

    public Enclosure getOldEnclosure() {
        return oldEnclosure;
    }

    public Enclosure getNewEnclosure() {
        return newEnclosure;
    }
}
