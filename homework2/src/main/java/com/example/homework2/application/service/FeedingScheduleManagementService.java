package com.example.homework2.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.homework2.application.repository.FeedingScheduleRepository;
import com.example.homework2.domain.entities.FeedingSchedule;
import com.example.homework2.domain.event.FeedingTimeEvent;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.homework2.domain.entities.Animal;
import com.example.homework2.domain.entities.FeedingSchedule;
import com.example.homework2.domain.event.FeedingTimeEvent;

@Service
public class FeedingScheduleManagementService {
    List<FeedingTimeEvent> feedingTimeEvents = new ArrayList<>();
    FeedingScheduleRepository fsr;

    public FeedingScheduleManagementService(FeedingScheduleRepository fsr) {
        this.fsr = fsr;
    }
    
    public FeedingSchedule getFeedingSchedule(int id) {
        return fsr.getFeedingSchedule(id);
    }

    public List<FeedingSchedule> getFeedingSchedules_actual() {
        return fsr.getFeedingSchedules(s -> s.getIsActual());
    }

    public List<FeedingSchedule> getFeedingSchedules() {
        return fsr.getFeedingSchedules(s -> Boolean.TRUE);
    }

    public int addFeedingSchedule(FeedingSchedule fs) {
        return fsr.addFeedingSchedule(fs);
    }

    public void removeFeedingSchedule(int id) {
        fsr.removeFeedingSchedule(id);
    }
    
    public FeedingTimeEvent organizeFeeding(int id) {
        FeedingSchedule fs = fsr.getFeedingSchedule(id);
        fs.getAnimal().feed(fs.getFood());
        FeedingTimeEvent event = new FeedingTimeEvent(fs);
        feedingTimeEvents.add(event);
        return event;
    }
}

