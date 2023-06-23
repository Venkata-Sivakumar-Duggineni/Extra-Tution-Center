package org.example;

public class Lesson {
    private Tutor tutor;
    private Student student;
    private TimeSlot timeSlot;
    private LessonStatus status;

    public Lesson(Tutor tutor, Student student, TimeSlot timeSlot) {
        this.tutor = tutor;
        this.student = student;
        this.timeSlot = timeSlot;
        this.status = LessonStatus.BOOKED;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Student getStudent() {
        return student;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public LessonStatus getStatus() {
        return status;
    }

    public void setStatus(LessonStatus status) {
        this.status = status;
    }
}