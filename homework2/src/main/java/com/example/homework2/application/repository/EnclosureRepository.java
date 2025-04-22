package com.example.homework2.application.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Repository;

import com.example.homework2.domain.entities.Enclosure;

@Repository
public interface EnclosureRepository {
    public int addEnclosure(Enclosure enclosure);
    public Enclosure getEnclosure(int id);
    public List<Enclosure> getEnclosures(Function<Enclosure, Boolean> filter);
    public void removeEnclosure(int id);
}

