package com.example.homework2.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.homework2.application.repository.EnclosureRepository;
import com.example.homework2.domain.entities.Animal;
import com.example.homework2.domain.entities.Enclosure;

@Service
public class EnclosureManagementService {
    EnclosureRepository er;

    public EnclosureManagementService(EnclosureRepository er) {
        this.er = er;
    }
    public Enclosure getEnclosure(int id) {
        return er.getEnclosure(id);
    }

    public List<Enclosure> getEnclosures() {
        return er.getEnclosures(a -> true);
    }
    
    public void removeEnclosure(int id) {
        er.removeEnclosure(id);
    }

    public int addEnclosure(Enclosure e) {
        return er.addEnclosure(e);
    }

}