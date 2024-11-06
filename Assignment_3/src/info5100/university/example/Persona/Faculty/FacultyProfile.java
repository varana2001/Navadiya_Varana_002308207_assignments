package info5100.university.example.Persona.Faculty;

import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.Persona.Person;
import java.util.ArrayList;

public class FacultyProfile {
    private Person person;
    private ArrayList<CourseOffer> courselist;
    
    public FacultyProfile(Person p) {
        person = p;
        courselist = new ArrayList<>();
    }
    
    public Person getPerson() {
        return person;
    }
    
    public void AssignAsTeacher(CourseOffer co) {
        courselist.add(co);
    }
}