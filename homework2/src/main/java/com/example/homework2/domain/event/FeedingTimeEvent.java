package com.example.homework2.domain.event;

import com.example.homework2.domain.entities.Animal;
import com.example.homework2.domain.entities.FeedingSchedule;

public class FeedingTimeEvent {
    private FeedingSchedule schedule;

    public FeedingTimeEvent(FeedingSchedule schedule) {
        this.schedule = schedule;
    }

    public FeedingSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(FeedingSchedule schedule) {
        this.schedule = schedule;
    }
}
