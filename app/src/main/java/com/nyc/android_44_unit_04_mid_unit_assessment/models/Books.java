package com.nyc.android_44_unit_04_mid_unit_assessment.models;

/**
 * Created by Wayne Kellman on 12/20/17.
 */

public class Books {
    private String title;
    private String author;
    private int year;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;

    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
