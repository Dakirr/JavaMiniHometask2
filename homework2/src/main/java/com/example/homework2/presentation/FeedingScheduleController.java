package com.example.homework2.presentation;

import com.example.homework2.application.service.FeedingScheduleManagementService;
import com.example.homework2.domain.entities.FeedingSchedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class FeedingScheduleController {
    private final FeedingScheduleManagementService feedingScheduleService;

    @Autowired
    public FeedingScheduleController(FeedingScheduleManagementService feedingScheduleService) {
        this.feedingScheduleService = feedingScheduleService;
    }

    @PostMapping("/api/feedingSchedules")
    public ResponseEntity<Integer> addFeedingSchedule(@RequestBody FeedingSchedule feedingSchedule) {
        int FeedingSchedule_id = feedingScheduleService.addFeedingSchedule(feedingSchedule);
        return new ResponseEntity<>(FeedingSchedule_id, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/feedingSchedules/{id}")
    public ResponseEntity<Integer> removeFeedingSchedule(@PathVariable int id) {
        feedingScheduleService.removeFeedingSchedule(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/api/feedingSchedules")
    public ResponseEntity<List<FeedingSchedule>> getFeedingSchedules() {
        List<FeedingSchedule> feedingSchedules = feedingScheduleService.getFeedingSchedules_actual();
        return new ResponseEntity<>(feedingSchedules, HttpStatus.OK);
    }

    @GetMapping("/api/feedingSchedules/{id}")
    public ResponseEntity<FeedingSchedule> getFeedingSchedule(@PathVariable int id) {
        FeedingSchedule feedingSchedule = feedingScheduleService.getFeedingSchedule(id);
        if (feedingSchedule != null) {
            return new ResponseEntity<>(feedingSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/feedingSchedules/{id}")
    public ResponseEntity<Integer> feed(@PathVariable int id) {
        feedingScheduleService.organizeFeeding(id);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }


}
