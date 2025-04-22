package com.example.homework2.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.homework2.domain.entities.Animal;
import com.example.homework2.domain.entities.Enclosure;
import com.example.homework2.domain.service.AnimalTransferService;


public class ZooControler {
    AnimalTransferService ats;

    @PostMapping("/api/zoo")
    public ResponseEntity<String> move(@RequestBody Animal A, @RequestBody Enclosure enclosure) {
        try {
            ats.move(A, enclosure);
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}