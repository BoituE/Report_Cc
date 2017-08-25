package com.example.admin.report_cc;

import java.io.Serializable;

/**
 * Created by Admin on 8/25/2017.
 */

public class UserModel implements Serializable {
    //setters and getters which will be used when a user wants to get some item or set one.
    private String name, hobby, city;
    private int id;


    public String getCity() {
        return city;

    }


    public void setCity(String city) {
        this.city = city;

    }
    public void setSubject(String city) {
        this.city = city;

    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;

    }


    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}


