package com.example.appville.model;

import android.icu.util.Calendar;

import java.io.Serializable;

/**
 * Created by Nicolas Th on 29/05/2017.
 */

public class Event implements Serializable {
    //---------------------------
    // ATTRIBUTS
    //---------------------------

    private Calendar calendar;
    private String title, description;

    //---------------------------
    // CONSTRUCTOR
    //---------------------------

    public Event(Calendar calendar, String title, String description) {
        this.calendar = calendar;
        this.title = title;
        this.description = description;
    }

    //---------------------------
    //          METHODE
    //---------------------------

    public boolean addInAgenda() {

        return true;
    }


    //---------------------------
    // GETTER SETTER
    //---------------------------


    @Override
    public String toString() {
        return super.toString();
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
