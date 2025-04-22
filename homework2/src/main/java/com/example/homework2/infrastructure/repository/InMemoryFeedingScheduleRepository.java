package com.example.homework2.application.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.stereotype.Repository;

import com.example.homework2.application.repository.FeedingScheduleRepository;
import com.example.homework2.domain.entities.Animal;
import com.example.homework2.domain.entities.FeedingSchedule;

@Repository
public class InMemoryFeedingScheduleRepository implements FeedingScheduleRepository {
    int cur_id = 0;
    private Map<Integer, FeedingSchedule> feeding_schedules;
    
    public InMemoryFeedingScheduleRepository() {
        feeding_schedules = new HashMap<>();
    }

    public int addFeedingSchedule(FeedingSchedule fs) {
        int tmp = cur_id;
        cur_id++;
        Integer I = tmp;
        feeding_schedules.put(I, fs);
        return tmp;
    }

    public FeedingSchedule getFeedingSchedule(int id) {
        Integer I = id;
        return feeding_schedules.get(I);
    }

    public void removeFeedingSchedule(int id) {
        Integer I = id;
        feeding_schedules.remove(I);
    }
    
    public List<FeedingSchedule> getFeedingSchedules(Function<FeedingSchedule, Boolean> filter) {
        List<FeedingSchedule> ret = new ArrayList<>();
        Set<Integer> keys = feeding_schedules.keySet();
        for (Integer I : keys) {
            if (filter.apply(feeding_schedules.get(I))) {
                ret.add(feeding_schedules.get(I));
            }
        }
        return ret;
    }
}
