package com.example.homework2.application.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Repository;

import com.example.homework2.application.repository.EnclosureRepository;
import com.example.homework2.domain.entities.Animal;
import com.example.homework2.domain.entities.Enclosure;

@Repository
public class InMemoryEnclosureRepository implements EnclosureRepository{
    private int cur_id = 0;
    private Map<Integer, Enclosure> enclosures;

    public InMemoryEnclosureRepository() {
        enclosures = new HashMap<>();
    }

    public int addEnclosure(Enclosure enclosure) {
        int tmp = cur_id;
        cur_id++;
        enclosures.put(tmp, enclosure);
        return tmp;
    }

    public Enclosure getEnclosure(int id) {
        return enclosures.get(id);
    }

    public List<Enclosure> getEnclosures(Function<Enclosure, Boolean> filter) {
        List<Enclosure> ret = new ArrayList<>();
        Set<Integer> keys = enclosures.keySet();
        for (Integer I : keys) {
            if (filter.apply(enclosures.get(I))) {
                ret.add(enclosures.get(I));
            }
        }
        return ret;
    }
    
    public void removeEnclosure(int id) {
        enclosures.remove(id);
    }

}

