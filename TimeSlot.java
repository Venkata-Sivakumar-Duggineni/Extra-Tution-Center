package org.example;

public class TimeSlot {
    private int week;
    private String day;
    private Time startTime;
    private Time endTime;
    private boolean isBooked;

    public TimeSlot(int week, String day, Time startTime, Time endTime) {
        this.week = week;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = false;
    }

    // Getters and setters

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return String.format("%s, %s - %s", day, startTime, endTime);
    }

}