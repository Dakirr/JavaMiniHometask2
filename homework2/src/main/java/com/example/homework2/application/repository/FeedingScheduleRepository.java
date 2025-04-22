package com.example.homework2.application.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Repository;

import com.example.homework2.domain.entities.Animal;
import com.example.homework2.domain.entities.FeedingSchedule;

@Repository
public interface FeedingScheduleRepository {
    public int addFeedingSchedule(FeedingSchedule fs);
    public FeedingSchedule getFeedingSchedule(int id);
    public void removeFeedingSchedule(int id);
    public List<FeedingSchedule> getFeedingSchedules(Function<FeedingSchedule, Boolean> filter);
}
