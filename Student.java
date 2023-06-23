package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    private String name;
    private String gender;
    private Date dob;
    private String emergencyContact;
    private List<Lesson> lessons;

    public Student(String name, String gender, Date dob, String emergencyContact) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.emergencyContact = emergencyContact;
        this.lessons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void viewTutorTimetable(Tutor tutor, int week) {
        Timetable timetable = tutor.getTimetables().get(week);
        if (timetable != null) {
            System.out.println("Tutor: " + tutor.getName());
            timetable.printTimetable();
        } else {
            System.out.println("Timetable not found for the specified week.");
        }
    }

    public void viewSubjectTimetable(String subject, List<Tutor> tutors, int week) {
        boolean flag = false;
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("Tutors teaching " + subject + ":");
        System.out.println("-------------------------------------");
        for (Tutor tutor : tutors) {
            if (tutor.getSubjects().contains(subject)) {
                viewTutorTimetable(tutor, week);
                System.out.println();
                flag = true;
            }
        }
        if (!flag){
            System.out.println("No Tutors Found");
        }
    }

    public void bookLesson(Tutor tutor, TimeSlot timeSlot) {
        if (timeSlot.isBooked()) {
            System.out.println("This timeslot is already booked. Please choose another timeslot.");
            return;
        }
        Lesson existingLesson = findLessonByTutorAndTimeSlot(tutor, timeSlot);
        if (existingLesson == null) {
            Lesson lesson = new Lesson(tutor, this, timeSlot);
            lessons.add(lesson);
            // Mark the timeslot as booked
            timeSlot.setBooked(true);
            System.out.println("Lesson booked successfully.");
            System.out.println("Tutor: " + tutor.getName());
            System.out.println("Timeslot: " + timeSlot);
            System.out.println();
        } else {
            System.out.println("Lesson already booked by another student.");
        }
    }

    public void changeBooking(Tutor tutor, TimeSlot timeSlot, List<Tutor> tutors) {
//        // Check if the old timeslot is booked by the current student
//        if (!timeSlot.isBooked()) {
//            System.out.println("This timeslot is not booked by you. Cannot change the booking.");
//            return;
//        }

        if (lessons.isEmpty()) {
            System.out.println("No lessons found for the student.");
            return;
        }

        Lesson existingLesson = findLessonByTutorAndTimeSlot(tutor, timeSlot);
        if (existingLesson == null) {
            System.out.println("Lesson not found. Cannot change booking.");
            return;
        }

        LessonStatus status = existingLesson.getStatus();
        if (status == LessonStatus.ATTENDED) {
            System.out.println("Lesson already attended. Cannot change booking.");
            return;
        }

        if (status == LessonStatus.CHANGED) {
            System.out.println("Lesson already changed. Cannot change booking again.");
            return;
        }

        if (status == LessonStatus.CANCELLED) {
            System.out.println("Lesson already cancelled. Cannot change booking.");
            return;
        }

        Tutor lessonTutor = existingLesson.getTutor();
        if (lessonTutor.equals(tutor)) {
            // Same tutor, find another available slot
            TimeSlot newSlot = findAvailableSlot(tutor, timeSlot.getWeek());
            if (newSlot == null) {
                System.out.println("No available slots found for the tutor. Cannot change booking.");
                return;
            }

            existingLesson.setTimeSlot(newSlot);
            existingLesson.setStatus(LessonStatus.CHANGED);
            System.out.println("Booking changed successfully to a different slot with the same tutor.");
        } else {
            // Different tutor, find available slot with the same subject
            TimeSlot newSlot = findAvailableSlotWithSubject(tutor.getSubjects(), timeSlot.getWeek(), tutors);
            if (newSlot == null) {
                System.out.println("No available slots found for the same subject. Cannot change booking.");
                return;
            }

            existingLesson.setTimeSlot(newSlot);
            existingLesson.setStatus(LessonStatus.CHANGED);
            System.out.println("Booking changed successfully to a different tutor with the same subject.");
        }
    }


    public void attendLesson(Lesson lesson) {
        if (!lessons.contains(lesson)) {
            System.out.println("Lesson not found.");
            return;
        }

        LessonStatus status = lesson.getStatus();
        if (status == LessonStatus.CANCELLED) {
            System.out.println("Lesson already cancelled. Cannot attend lesson.");
            return;
        }

        if (status == LessonStatus.ATTENDED) {
            System.out.println("Lesson already attended.");
            return;
        }

        lesson.setStatus(LessonStatus.ATTENDED);
        System.out.println("Lesson attended. Please provide a review and rating.");
        // TODO: Implement review and rating functionality
    }

    public void cancelBooking(Lesson lesson) {
        if (!lessons.contains(lesson)) {
            System.out.println("Lesson not found.");
            return;
        }

        LessonStatus status = lesson.getStatus();
        if (status == LessonStatus.ATTENDED) {
            System.out.println("Lesson already attended. Cannot cancel booking.");
            return;
        }

        if (status == LessonStatus.CHANGED) {
            System.out.println("Lesson already changed. Cannot cancel booking.");
            return;
        }

        if (status == LessonStatus.CANCELLED) {
            System.out.println("Lesson already cancelled.");
            return;
        }

        lessons.remove(lesson);
        System.out.println("Booking cancelled successfully.");
    }

    private TimeSlot findAvailableSlot(Tutor tutor, int week) {
        List<TimeSlot> tutorSlots = tutor.getTimetables().get(week).getTutorSlots(tutor, week);
        for (TimeSlot slot : tutorSlots) {
            Lesson existingLesson = findLessonByTutorAndTimeSlot(tutor, slot);
            if (existingLesson == null || existingLesson.getStatus() == LessonStatus.CANCELLED ) {
                return slot;
            }
        }
        return null;
    }

    private List<Tutor> findTutorsBySubject(String subject, List<Tutor> tutors) {
        List<Tutor> subjectTutors = new ArrayList<>();
        for (Tutor tutor : tutors) {
            if (tutor.getSubjects().contains(subject)) {
                subjectTutors.add(tutor);
            }
        }
        return subjectTutors;
    }

    private TimeSlot findAvailableSlotWithSubject(List<String> subjects, int week, List<Tutor> tutors) {
        for (String subject : subjects) {
            List<Tutor> subjectTutors = findTutorsBySubject(subject, tutors);
            for (Tutor tutor : subjectTutors) {
                TimeSlot availableSlot = findAvailableSlot(tutor, week);
                if (availableSlot != null) {
                    return availableSlot;
                }
            }
        }
        return null;
    }


    private Lesson findLessonByTutorAndTimeSlot(Tutor tutor, TimeSlot timeSlot) {
        for (Lesson lesson : lessons) {
            if (lesson.getTutor().equals(tutor) && lesson.getTimeSlot().equals(timeSlot)) {
                return lesson;
            }
        }
        return null;
    }

}