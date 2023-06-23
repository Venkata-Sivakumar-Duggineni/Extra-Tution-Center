package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// LessonStatus enum
enum LessonStatus {
    BOOKED,
    ATTENDED,
    CHANGED,
    CANCELLED
}

public class Main {
    private static List<Tutor> tutors = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();


    public static void main(String[] args) {
        // Create tutors
        Tutor tutor1 = new Tutor("John Doe", Arrays.asList("Math", "English"));
        Tutor tutor2 = new Tutor("Jane Smith", Arrays.asList("Math", "Science"));
        Tutor tutor3 = new Tutor("Chris Evans", Arrays.asList("Commerce", "English"));
//        Tutor tutor4 = new Tutor("Emma Johnson", Arrays.asList("Physics", "Chemistry"));
//        Tutor tutor5 = new Tutor("Michael Brown", Arrays.asList("History", "Geography"));

        // Create a list of tutors
        List<Tutor> tutors = new ArrayList<>();
        tutors.add(tutor1);
        tutors.add(tutor2);
        tutors.add(tutor3);
//        tutors.add(tutor4);
//        tutors.add(tutor5);

        // Create timetables for tutors for two weeks

        // Week 1
        Timetable tutor1Week1Timetable = new Timetable();
        tutor1Week1Timetable.addSlot(tutor1, new TimeSlot(1, "Monday", new Time(9, 0), new Time(10, 0)));
        tutor1Week1Timetable.addSlot(tutor1, new TimeSlot(1, "Tuesday", new Time(11, 0), new Time(12, 0)));
        tutor1Week1Timetable.addSlot(tutor1, new TimeSlot(1, "Wednesday", new Time(14, 0), new Time(15, 0)));
        tutor1Week1Timetable.addSlot(tutor1, new TimeSlot(1, "Thursday", new Time(16, 0), new Time(17, 0)));
        tutor1Week1Timetable.addSlot(tutor1, new TimeSlot(1, "Friday", new Time(10, 0), new Time(11, 0)));
        tutor1Week1Timetable.addSlot(tutor1, new TimeSlot(1, "Saturday", new Time(12, 0), new Time(13, 0)));
        tutor1Week1Timetable.addSlot(tutor1, new TimeSlot(1, "Sunday", new Time(14, 0), new Time(15, 0)));

        Timetable tutor2Week1Timetable = new Timetable();
        tutor2Week1Timetable.addSlot(tutor2, new TimeSlot(1, "Monday", new Time(10, 0), new Time(11, 0)));
        tutor2Week1Timetable.addSlot(tutor2, new TimeSlot(1, "Tuesday", new Time(12, 0), new Time(13, 0)));
        tutor2Week1Timetable.addSlot(tutor2, new TimeSlot(1, "Wednesday", new Time(16, 0), new Time(17, 0)));
        tutor2Week1Timetable.addSlot(tutor2, new TimeSlot(1, "Thursday", new Time(9, 0), new Time(10, 0)));
        tutor2Week1Timetable.addSlot(tutor2, new TimeSlot(1, "Friday", new Time(11, 0), new Time(12, 0)));
        tutor2Week1Timetable.addSlot(tutor2, new TimeSlot(1, "Saturday", new Time(13, 0), new Time(14, 0)));
        tutor2Week1Timetable.addSlot(tutor2, new TimeSlot(1, "Sunday", new Time(15, 0), new Time(16, 0)));

        Timetable tutor3Week1Timetable = new Timetable();
        tutor3Week1Timetable.addSlot(tutor3, new TimeSlot(1, "Monday", new Time(11, 0), new Time(12, 0)));
        tutor3Week1Timetable.addSlot(tutor3, new TimeSlot(1, "Tuesday", new Time(9, 0), new Time(10, 0)));
        tutor3Week1Timetable.addSlot(tutor3, new TimeSlot(1, "Wednesday", new Time(12, 0), new Time(13, 0)));
        tutor3Week1Timetable.addSlot(tutor3, new TimeSlot(1, "Thursday", new Time(14, 0), new Time(15, 0)));
        tutor3Week1Timetable.addSlot(tutor3, new TimeSlot(1, "Friday", new Time(16, 0), new Time(17, 0)));
        tutor3Week1Timetable.addSlot(tutor3, new TimeSlot(1, "Saturday", new Time(9, 0), new Time(10, 0)));
        tutor3Week1Timetable.addSlot(tutor3, new TimeSlot(1, "Sunday", new Time(11, 0), new Time(12, 0)));

        // Week 2
        Timetable tutor1Week2Timetable = new Timetable();
        tutor1Week2Timetable.addSlot(tutor1, new TimeSlot(2, "Monday", new Time(10, 0), new Time(11, 0)));
        tutor1Week2Timetable.addSlot(tutor1, new TimeSlot(2, "Tuesday", new Time(12, 0), new Time(13, 0)));
        tutor1Week2Timetable.addSlot(tutor1, new TimeSlot(2, "Wednesday", new Time(16, 0), new Time(17, 0)));
        tutor1Week2Timetable.addSlot(tutor1, new TimeSlot(2, "Thursday", new Time(9, 0), new Time(10, 0)));
        tutor1Week2Timetable.addSlot(tutor1, new TimeSlot(2, "Friday", new Time(11, 0), new Time(12, 0)));
        tutor1Week2Timetable.addSlot(tutor1, new TimeSlot(2, "Saturday", new Time(13, 0), new Time(14, 0)));
        tutor1Week2Timetable.addSlot(tutor1, new TimeSlot(2, "Sunday", new Time(15, 0), new Time(16, 0)));

        Timetable tutor2Week2Timetable = new Timetable();
        tutor2Week2Timetable.addSlot(tutor2, new TimeSlot(2, "Monday", new Time(9, 0), new Time(10, 0)));
        tutor2Week2Timetable.addSlot(tutor2, new TimeSlot(2, "Tuesday", new Time(11, 0), new Time(12, 0)));
        tutor2Week2Timetable.addSlot(tutor2, new TimeSlot(2, "Wednesday", new Time(14, 0), new Time(15, 0)));
        tutor2Week2Timetable.addSlot(tutor2, new TimeSlot(2, "Thursday", new Time(16, 0), new Time(17, 0)));
        tutor2Week2Timetable.addSlot(tutor2, new TimeSlot(2, "Friday", new Time(10, 0), new Time(11, 0)));
        tutor2Week2Timetable.addSlot(tutor2, new TimeSlot(2, "Saturday", new Time(12, 0), new Time(13, 0)));
        tutor2Week2Timetable.addSlot(tutor2, new TimeSlot(2, "Sunday", new Time(14, 0), new Time(15, 0)));

        Timetable tutor3Week2Timetable = new Timetable();
        tutor3Week2Timetable.addSlot(tutor3, new TimeSlot(2, "Monday", new Time(11, 0), new Time(12, 0)));
        tutor3Week2Timetable.addSlot(tutor3, new TimeSlot(2, "Tuesday", new Time(9, 0), new Time(10, 0)));
        tutor3Week2Timetable.addSlot(tutor3, new TimeSlot(2, "Wednesday", new Time(12, 0), new Time(13, 0)));
        tutor3Week2Timetable.addSlot(tutor3, new TimeSlot(2, "Thursday", new Time(14, 0), new Time(15, 0)));
        tutor3Week2Timetable.addSlot(tutor3, new TimeSlot(2, "Friday", new Time(16, 0), new Time(17, 0)));
        tutor3Week2Timetable.addSlot(tutor3, new TimeSlot(2, "Saturday", new Time(9, 0), new Time(10, 0)));
        tutor3Week2Timetable.addSlot(tutor3, new TimeSlot(2, "Sunday", new Time(11, 0), new Time(12, 0)));

        // Assign timetables to tutors
        tutor1.addTimetable(1, tutor1Week1Timetable);
        tutor1.addTimetable(2, tutor1Week2Timetable);
        tutor2.addTimetable(1, tutor2Week1Timetable);
        tutor2.addTimetable(2, tutor2Week2Timetable);
        tutor3.addTimetable(1, tutor3Week1Timetable);
        tutor3.addTimetable(2, tutor3Week2Timetable);

        // Create students
        Student student1 = new Student("Alice", "Female", new Date(), "1234567890");
        Student student2 = new Student("Bob", "Male", new Date(), "0987654321");
//        Student student3 = new Student("Eva", "Female", new Date(), "9876543210");
//        Student student4 = new Student("David", "Male", new Date(), "0123456789");

        // Test the functionality
        student1.viewTutorTimetable(tutor1, 1);
        student1.viewSubjectTimetable("Math", tutors, 1);

        TimeSlot bookedSlot = tutor1.getTimetables().get(1).getTutorSlots(tutor1, 1).get(0);
        student1.bookLesson(tutor1, bookedSlot);
        student1.bookLesson(tutor1, bookedSlot); // Testing duplicate booking

        // to check if booked timeslots are being displayed in the timetable
        student1.viewTutorTimetable(tutor1, 1);
        student1.viewSubjectTimetable("Math", tutors, 1);

        student1.changeBooking(tutor1, bookedSlot, tutors);

        student1.attendLesson(student1.getLessons().get(0));
        student1.cancelBooking(student1.getLessons().get(0));

        student2.bookLesson(tutor2, bookedSlot); // Testing booking for another student

        student2.viewTutorTimetable(tutor1, 2); // Testing timetable not found
        student2.viewSubjectTimetable("Commerce", tutors, 1); // Testing subject not found
    }

}