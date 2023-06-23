package org.example;

import java.util.*;

public class Timetable {
    private Map<Tutor, List<TimeSlot>> slots;

    public Timetable() {
        this.slots = new HashMap<>();
    }

    public Map<Tutor, List<TimeSlot>> getSlots() {
        return slots;
    }

    public void addSlot(Tutor tutor, TimeSlot timeSlot) {
        List<TimeSlot> tutorSlots = slots.getOrDefault(tutor, new ArrayList<>());
        tutorSlots.add(timeSlot);
        slots.put(tutor, tutorSlots);
    }

    public List<TimeSlot> getTutorSlots(Tutor tutor, int week) {
        List<TimeSlot> tutorSlots = slots.get(tutor);
        if (tutorSlots == null) {
            return Collections.emptyList();
        }
        List<TimeSlot> filteredSlots = new ArrayList<>();
        for (TimeSlot slot : tutorSlots) {
            if (slot.getWeek() == week) {
                filteredSlots.add(slot);
            }
        }
        return filteredSlots;
    }

    public void printTimetable() {
        for (Tutor tutor : slots.keySet()) {
//            System.out.println("Tutor: " + tutor.getName());
            System.out.println("----------------------------------------------------");
            System.out.println("Week\tDay\t\t\t\tStart Time\tEnd Time");
            System.out.println("----------------------------------------------------");
            List<TimeSlot> tutorSlots = slots.get(tutor);
            for (TimeSlot slot : tutorSlots) {
                if(!slot.isBooked()) {
                    System.out.println(slot.getWeek() + "\t\t" + slot.getDay() + "\t\t\t" +
                            slot.getStartTime().getHours() + ":" + slot.getStartTime().getMinutes() + "\t\t\t" +
                            slot.getEndTime().getHours() + ":" + slot.getEndTime().getMinutes());
                }
            }
            System.out.println();
        }
    }
}