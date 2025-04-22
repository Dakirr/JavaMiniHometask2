package com.example.homework2.domain.value_object;

public class Time {
    int hour;
    int minute;

    public Time(int hour, int minute) throws Exception {
        if (this.hour < 0 || this.hour > 23 || this.minute < 0 || this.minute > 59) {
            throw new Exception("Invalid time");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

}
