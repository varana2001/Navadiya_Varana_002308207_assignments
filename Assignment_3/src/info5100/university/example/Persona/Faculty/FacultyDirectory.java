package info5100.university.example.Persona.Faculty;

import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Person;
import java.util.ArrayList;

public class FacultyDirectory {
    private Department department;
    private ArrayList<FacultyProfile> facultylist;
    
    public FacultyDirectory(Department d) {
        department = d;
        facultylist = new ArrayList<>();
    }
    
    public FacultyProfile newFacultyProfile(Person p) {
        FacultyProfile fp = new FacultyProfile(p);
        facultylist.add(fp);
        return fp;
    }
    
    public ArrayList<FacultyProfile> getFacultyList() {
        return facultylist;
    }
}