package info5100.university.example;

import info5100.university.example.CourseCatalog.*;
import info5100.university.example.CourseSchedule.*;
import info5100.university.example.Department.*;
import info5100.university.example.Persona.Faculty.*;
import info5100.university.example.Persona.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniversityManagementSystem {

    Department department;
    PersonDirectory personDirectory;
    CourseCatalog courseCatalog;
    CourseSchedule courseSchedule;
    FacultyDirectory facultyDirectory;
    StudentDirectory studentDirectory;

    public UniversityManagementSystem(String departmentName) {
        // Initialize the department and get all necessary directories
        department = new Department(departmentName);
        personDirectory = department.getPersonDirectory();
        courseCatalog = department.getCourseCatalog();
        facultyDirectory = department.getFacultyDirectory();
        studentDirectory = department.getStudentDirectory();
        courseSchedule = department.newCourseSchedule("Fall 2024");
    }

    public void setupCourseCatalog() {
        // Core course
        courseCatalog.newCourse("Advanced Software Development", "INFO5105", 4, true);

        // Elective courses
        courseCatalog.newCourse("Human-Computer Interaction", "INFO6155", 4, false);
        courseCatalog.newCourse("Algorithm Design & Optimization", "INFO6206", 4, false);
        courseCatalog.newCourse("Data Storage & Retrieval", "INFO6215", 4, false);
        courseCatalog.newCourse("Web Application Frameworks", "INFO6255", 4, false);
        courseCatalog.newCourse("Mobile App Development", "INFO6355", 4, false);
        courseCatalog.newCourse("Distributed Systems", "INFO6305", 4, false);
        courseCatalog.newCourse("Data Engineering", "INFO6405", 4, false);
        courseCatalog.newCourse("Network Security", "INFO6505", 4, false);
        courseCatalog.newCourse("Deep Learning & AI", "INFO6605", 4, false);
    }
    public void setupFaculty() {
        String[][] facultyData = {
        {"F101", "Linda", "Evans"},
        {"F102", "David", "Harris"},
        {"F103", "Susan", "Clark"},
        {"F104", "Karen", "Lewis"},
        {"F105", "Matthew", "Walker"},
        {"F106", "Jessica", "Robinson"},
        {"F107", "Daniel", "Hall"}
        };

        for (String[] data : facultyData) {
            // Use the new newPerson method with all parameters
            Person facultyPerson = department.getPersonDirectory().newPerson(data[0], data[1], data[2]);
            facultyDirectory.newFacultyProfile(facultyPerson);
        }
    }

    public void setupStudents() {
        String[][] studentData = {
        {"S101", "Lily", "Ramirez"},
        {"S102", "Jack", "Nguyen"},
        {"S103", "Zoe", "Thomas"},
        {"S104", "Ethan", "Lopez"},
        {"S105", "Chloe", "Clark"},
        {"S106", "Benjamin", "Jain"},
        {"S107", "Ella", "Sharma"},
        {"S108", "Henry", "Ali"},
        {"S109", "Emily", "Hernandez"},
        {"S110", "Jacob", "Zhou"}
            };
        for (String[] data : studentData) {
            // Use the new newPerson method with all parameters
            Person studentPerson = department.getPersonDirectory().newPerson(data[0], data[1], data[2]);
            studentDirectory.newStudentProfile(studentPerson);
        }
    }
}
