/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

public class CourseOffer {
    Course course;
    ArrayList<Seat> seatlist;
    FacultyProfile facultyProfile;
    String section;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList<>();
    }
    
    public void setSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public void generatSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this));
        }
    }

    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public Course getCourse() {
        return course;
    }

    public void AssignAsTeacher(FacultyProfile fp) {
        facultyProfile = fp;
    }

    public FacultyProfile getFacultyProfile() {
        return facultyProfile;
    }

    public int getTotalCourseRevenues() {
        int sum = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                sum = sum + course.getCoursePrice();
            }
        }
        return sum;
    }
}