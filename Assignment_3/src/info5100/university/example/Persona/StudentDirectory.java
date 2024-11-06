package info5100.university.example.Persona;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

public class StudentDirectory {
    Department department;
    ArrayList<StudentProfile> studentlist;
    
    public StudentDirectory(Department d) {
        department = d;
        studentlist = new ArrayList<>();
    }
    
    public StudentProfile newStudentProfile(Person p) {
        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }
    
    public ArrayList<StudentProfile> getStudentlist() {
        return studentlist;
    }
}
