package com.example.homework2.domain.service;

import java.util.ArrayList;
import com.example.homework2.domain.entities.Animal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.homework2.domain.entities.Enclosure;
import com.example.homework2.domain.event.AnimalMovedEvent;

@Service
public class AnimalTransferService {
    List<AnimalMovedEvent> animalMovedEvents = new ArrayList<>();

    public AnimalTransferService() {
    }

    boolean check_if_not_full(Enclosure enclosure) throws Exception {
        if (enclosure.getCurrent_animals_number() + 1 > enclosure.getMax_animals_number()) {
            throw new Exception("Enclosure is full");
        } else {
            return true;
        }
    }

    boolean check_if_suitable(Animal animal, Enclosure enclosure) throws Exception {
        if (enclosure.getType() != animal.getSpecies().getType()) {
            throw new Exception("Animal is not suitablle for enclosure");
        } else {
            return true;
        }
    }

    public AnimalMovedEvent move(Animal animal, Enclosure newEnclosure) throws Exception {    
        Enclosure oldEnclosure = animal.getEnclosure();        
        if (check_if_not_full(newEnclosure) && check_if_suitable(animal, newEnclosure)) {
            oldEnclosure.remove_animal(animal);
            newEnclosure.add_animal(animal);
            animal.setEnclosure(newEnclosure);
            AnimalMovedEvent event = new AnimalMovedEvent(animal, oldEnclosure, newEnclosure);
            animalMovedEvents.add(event);
            return event;
        }
        return null;
    }

    public void setAnimalMovedEvents(List<AnimalMovedEvent> animalMovedEvents) {
        this.animalMovedEvents = animalMovedEvents;
    }

    public List<AnimalMovedEvent> getAnimalMovedEvents() {
        return animalMovedEvents;
    }
    
}
