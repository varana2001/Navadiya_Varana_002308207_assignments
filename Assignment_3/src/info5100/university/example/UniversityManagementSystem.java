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
    
        public void setupCourseSchedule() {
        // Create multiple sections for some courses to reach 10 scheduled classes
        String[] courseSchedules = {
            "INFO5100-SEC1", // Core course section 1
            "INFO5100-SEC2", // Core course section 2 (multiple sections for core course)
            "INFO6150-SEC1",
            "INFO6205-SEC1",
            "INFO6210-SEC1",
            "INFO6250-SEC1",
            "INFO6350-SEC1",
            "INFO6300-SEC1",
            "INFO6400-SEC1",
            "INFO6500-SEC1"
        };

        // Track assigned courses per faculty to ensure balanced distribution
        Map<FacultyProfile, Integer> facultyLoadCount = new HashMap<>();
        FacultyProfile[] faculty = facultyDirectory.getFacultyList().toArray(new FacultyProfile[0]);
        for (FacultyProfile fp : faculty) {
            facultyLoadCount.put(fp, 0);
        }

        // Create course offerings with sections
        for (String scheduleItem : courseSchedules) {
            String[] parts = scheduleItem.split("-"); // Split into courseNumber and section
            String courseNumber = parts[0];

            CourseOffer offer = courseSchedule.newCourseOffer(courseNumber);
            if (offer != null) {
                offer.generatSeats(30); // Each section can accommodate 30 students

                // Assign faculty with the least number of courses
                FacultyProfile selectedFaculty = getLeastLoadedFaculty(facultyLoadCount);
                offer.AssignAsTeacher(selectedFaculty);
                facultyLoadCount.put(selectedFaculty, facultyLoadCount.get(selectedFaculty) + 1);

                // Store section information
                offer.setSection(parts[1]);
            }
        }
    }

    private FacultyProfile getLeastLoadedFaculty(Map<FacultyProfile, Integer> facultyLoadCount) {
        return facultyLoadCount.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public void registerStudents() {
        CourseOffer[] offers = courseSchedule.getCourseOffers().toArray(new CourseOffer[0]);
        int totalRegistrations = 0;

        for (StudentProfile student : studentDirectory.getStudentlist()) {
            CourseLoad courseLoad = student.newCourseLoad("Fall 2024");

            // Each student must take:
            // 1. One section of the core course (INFO5100)
            // 2. At least one elective course
            // Register for core course
            CourseOffer coreSection = getAvailableCoreSection();
            if (coreSection != null) {
                courseLoad.registerStudentInClass(coreSection);
                totalRegistrations++;
            }

            // Register for 1-2 elective courses
            int numElectives = 1 + (int) (Math.random() * 2); // 1 or 2 electives
            for (int i = 0; i < numElectives; i++) {
                CourseOffer electiveOffer = getRandomElectiveOffer(offers);
                if (electiveOffer != null) {
                    courseLoad.registerStudentInClass(electiveOffer);
                    totalRegistrations++;
                }
            }
        }

        // Verify minimum registration requirement
        System.out.println("\nRegistration Statistics:");
        System.out.println("Total course registrations: " + totalRegistrations);
        if (totalRegistrations < 20) {
            System.out.println("WARNING: Minimum registration requirement (20) not met!");
        } else {
            System.out.println("Registration requirement met successfully.");
        }
    }

    private CourseOffer getAvailableCoreSection() {
        return courseSchedule.getCourseOffers().stream()
                .filter(offer -> offer.getCourse().isCore() && offer.getEmptySeat() != null)
                .findFirst()
                .orElse(null);
    }

    private CourseOffer getRandomElectiveOffer(CourseOffer[] offers) {
        List<CourseOffer> availableElectives = Arrays.stream(offers)
                .filter(offer -> !offer.getCourse().isCore() && offer.getEmptySeat() != null)
                .collect(Collectors.toList());

        if (availableElectives.isEmpty()) {
            return null;
        }

        int randomIndex = (int) (Math.random() * availableElectives.size());
        return availableElectives.get(randomIndex);
    }
}
