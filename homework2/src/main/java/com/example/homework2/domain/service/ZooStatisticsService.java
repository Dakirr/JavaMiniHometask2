package com.example.homework2.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.homework2.domain.entities.Animal;
import com.example.homework2.domain.entities.Enclosure;

@Service
public class ZooStatisticsService {
    public ZooStatisticsService() {
    }
    
    public String get_statistics(List<Enclosure> enclosures) {
        String ret = "";

        for (Enclosure e : enclosures) {
            ret += e.get_string();
        }

        return ret;
    }   
}
