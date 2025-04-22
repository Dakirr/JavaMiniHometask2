package com.example.homework2.domain.value_object;

public class AnimalType {
    private String type;

    public AnimalType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }        

    public String get_string () {
        return type;
    }
}
