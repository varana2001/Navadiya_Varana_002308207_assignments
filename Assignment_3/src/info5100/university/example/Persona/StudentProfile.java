package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentProfile {
    Person person;
    HashMap<String, CourseLoad> courseloadlist;
    
    public StudentProfile(Person p) {
        person = p;
        courseloadlist = new HashMap<>();
    }
    
    public CourseLoad newCourseLoad(String sem) {
        CourseLoad cl = new CourseLoad(sem);
        courseloadlist.put(sem, cl);
        return cl;
    }
    
    public Person getPerson() {
        return person;
    }
    
    public CourseLoad getCurrentCourseLoad() {
        return courseloadlist.get("Fall 2024");
    }
}