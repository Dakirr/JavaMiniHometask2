package com.example.homework2.presentation;

import com.example.homework2.application.service.EnclosureManagementService;
import com.example.homework2.domain.entities.Enclosure;
import com.example.homework2.domain.service.ZooStatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EnclosureController {
    private EnclosureManagementService enclosureManagementService;
    private ZooStatisticsService zss;


    public EnclosureController(EnclosureManagementService enclosureManagementService) {
        this.enclosureManagementService = enclosureManagementService;
    }
    
    @GetMapping("/api/enclosures")
    public ResponseEntity<List<Enclosure>> getEnclosures() {
        List<Enclosure> enclosures = enclosureManagementService.getEnclosures();
        return new ResponseEntity<>(enclosures, HttpStatus.OK);
    }

    @GetMapping("/api/enclosures/{id}")
    public ResponseEntity<Enclosure> getEnclosure(@PathVariable int id) {
        Enclosure enclosure = enclosureManagementService.getEnclosure(id);
        if (enclosure != null) {
            return new ResponseEntity<>(enclosure, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/enclosures/{id}")
    public ResponseEntity<Integer> removeEnclosure(@PathVariable int id) {
        enclosureManagementService.removeEnclosure(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/api/enclosures")
    public ResponseEntity<Integer> addEnclosure(@RequestBody Enclosure enclosure) {
        int Enclosure_id = enclosureManagementService.addEnclosure(enclosure);
        return new ResponseEntity<>(Enclosure_id, HttpStatus.CREATED);
    }

    @GetMapping("/api/enclosures/info")
    public ResponseEntity<String> getInfo() {
        return new ResponseEntity<>(zss.get_statistics(enclosureManagementService.getEnclosures()), HttpStatus.OK);
    }
    

}
    