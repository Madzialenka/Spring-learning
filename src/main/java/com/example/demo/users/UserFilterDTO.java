package com.example.demo.users;

import com.example.demo.customers.Gender;

public class UserFilterDTO {
    private String name;
    private Gender gender;

    public UserFilterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
