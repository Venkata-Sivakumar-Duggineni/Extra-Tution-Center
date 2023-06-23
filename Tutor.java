package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tutor {
    private String name;
    private List<String> subjects;
    private Map<Integer, Timetable> timetables;

    public Tutor(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
        this.timetables = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public Map<Integer, Timetable> getTimetables() {
        return timetables;
    }

    public void addTimetable(int week, Timetable timetable) {
        timetables.put(week, timetable);
    }



}