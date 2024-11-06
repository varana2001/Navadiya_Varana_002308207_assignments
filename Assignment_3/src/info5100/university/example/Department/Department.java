package info5100.university.example.Department;

import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import java.util.ArrayList;

public class Department {
    String name;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    CourseCatalog coursecatalog;
    ArrayList<CourseSchedule> schedulelist;

    public Department(String n) {
        name = n;
        persondirectory = new PersonDirectory();
        studentdirectory = new StudentDirectory(this);
        facultydirectory = new FacultyDirectory(this);
        coursecatalog = new CourseCatalog();
        schedulelist = new ArrayList<>();
    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public StudentDirectory getStudentDirectory() {
        return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {
        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        schedulelist.add(cs);
        return cs;
    }

    public CourseCatalog getCourseCatalog() {
        return coursecatalog;
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultydirectory;
    }

    public int calculateRevenuesBySemester(String semester) {
        int sum = 0;
        for (CourseSchedule cs : schedulelist) {
            sum = sum + cs.calculateTotalRevenues();
        }
        return sum;
    }
}