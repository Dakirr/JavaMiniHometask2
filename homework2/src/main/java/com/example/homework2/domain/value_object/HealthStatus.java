package com.example.homework2.domain.value_object;

public class HealthStatus {
    private String HS;

    public HealthStatus(String HS) {
        this.HS = HS;
    }

    public void set(String HS) {
        this.HS = HS;
    }

    public String get() {
        return HS;
    }
    
}
