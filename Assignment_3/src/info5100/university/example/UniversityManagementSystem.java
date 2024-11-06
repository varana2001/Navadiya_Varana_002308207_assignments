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
        courseCatalog.newCourse("Applied Engineering and Development", "INFO5100", 4, true);

        // Elective courses
        courseCatalog.newCourse("Cloud Computing", "INFO6300", 4, false);
        courseCatalog.newCourse("Data Science Engineering", "INFO6400", 4, false);
        courseCatalog.newCourse("Cyber Security", "INFO6500", 4, false);
        courseCatalog.newCourse("AI & Machine Learning", "INFO6600", 4, false);
        courseCatalog.newCourse("Web Design & User Experience", "INFO6150", 4, false);
        courseCatalog.newCourse("Program Structure & Algorithms", "INFO6205", 4, false);
        courseCatalog.newCourse("Database Management Systems", "INFO6210", 4, false);
        courseCatalog.newCourse("Web Development Tools & Methods", "INFO6250", 4, false);
        courseCatalog.newCourse("Smartphone-based Web Development", "INFO6350", 4, false);

    }

    public void setupFaculty() {
        String[][] facultyData = {
            {"F001", "Jane", "Smith"},
            {"F002", "Mark", "Johnson"},
            {"F003", "Robert", "Williams"},
            {"F004", "Patricia", "Brown"},
            {"F005", "George", "Davis"},
            {"F006", "Elena", "Miller"},
            {"F007", "John", "Wilson"}
        };

        for (String[] data : facultyData) {
            // Use the new newPerson method with all parameters
            Person facultyPerson = department.getPersonDirectory().newPerson(data[0], data[1], data[2]);
            facultyDirectory.newFacultyProfile(facultyPerson);
        }
    }

    public void setupStudents() {
        String[][] studentData = {
            {"S001", "Tom", "Garcia"},
            {"S002", "Amar", "Martinez"},
            {"S003", "Arick", "Rodriguez"},
            {"S004", "Jack", "Lee"},
            {"S005", "Ava", "Wang"},
            {"S006", "William", "Kumar"},
            {"S007", "Sophia", "Chen"},
            {"S008", "Mason", "Singh"},
            {"S009", "Elena", "Patel"},
            {"S010", "Lucas", "Kim"}
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

    public void generateSemesterReport() {        
        System.out.println("\n====================== SEMESTER REPORT - Fall 2024 ======================\n");
        
        // Print Schedule Summary
        System.out.println("COURSE SCHEDULE SUMMARY:");
        System.out.println("------------------------");
        Map<FacultyProfile, List<CourseOffer>> facultyTeachingLoad = new HashMap<>();
        
        for (CourseOffer offer : courseSchedule.getCourseOffers()) {
            FacultyProfile faculty = offer.getFacultyProfile();
            facultyTeachingLoad.computeIfAbsent(faculty, k -> new ArrayList<>()).add(offer);
        }
        
        System.out.println("\nFACULTY TEACHING ASSIGNMENTS:");
        for (Map.Entry<FacultyProfile, List<CourseOffer>> entry : facultyTeachingLoad.entrySet()) {
            FacultyProfile faculty = entry.getKey();
            List<CourseOffer> courses = entry.getValue();
            
            System.out.printf("\nProfessor: %s\n", faculty.getPerson().getFullName());
            System.out.println("Teaching:");
            for (CourseOffer offer : courses) {
                Course course = offer.getCourse();
                System.out.printf("  - %s %s: %s (%s)\n",
                    course.getCourseNumber(),
                    offer.getSection(),
                    course.getName(),
                    course.isCore() ? "Core" : "Elective");
            }
        }

        // First print course catalog information
        System.out.println("COURSE CATALOG:");
        System.out.println("-------------");
        for (CourseOffer offer : courseSchedule.getCourseOffers()) {
            Course course = offer.getCourse();
            System.out.printf("%s - %s (%s)\n"
                    + "Credits: %d\n"
                    + "Cost per Credit: $%,d\n"
                    + "Total Course Cost: $%,d\n"
                    + "Type: %s\n"
                    + "Instructor: %s\n\n",
                    course.getCourseNumber(),
                    course.getName(),
                    course.getCredits() + " credits",
                    course.getCredits(),
                    course.getPricePerCredit(),
                    course.getCoursePrice(),
                    course.isCore() ? "Core Course" : "Elective Course",
                    offer.getFacultyProfile().getPerson().getFullName());
        }

        System.out.println("\nSTUDENT REGISTRATIONS AND GRADES:");
        System.out.println("--------------------------------");

        int totalRegistrations = 0;

        for (StudentProfile student : studentDirectory.getStudentlist()) {
            Person studentPerson = student.getPerson();
            System.out.printf("\nStudent: %s (ID: %s)\n",
                    studentPerson.getFullName(),
                    studentPerson.getPersonId());

            CourseLoad courseLoad = student.getCurrentCourseLoad();
            if (courseLoad != null) {
                System.out.println("Courses Registered:");
                double totalGradePoints = 0;
                int totalCredits = 0;
                int totalTuition = 0;

                for (SeatAssignment seat : courseLoad.getSeatassignments()) {
                    totalRegistrations++;

                    CourseOffer offer = seat.getSeat().getCourseoffer();
                    Course course = offer.getCourse();
                    Person professor = offer.getFacultyProfile().getPerson();

                    double grade = 2.0 + (Math.random() * 2.0);
                    seat.assignGrade(grade);

                    String letterGrade;
                    if (grade >= 3.7) {
                        letterGrade = "A";
                    } else if (grade >= 3.3) {
                        letterGrade = "A-";
                    } else if (grade >= 3.0) {
                        letterGrade = "B+";
                    } else if (grade >= 2.7) {
                        letterGrade = "B";
                    } else if (grade >= 2.3) {
                        letterGrade = "B-";
                    } else {
                        letterGrade = "C+";
                    }

                    System.out.printf("  - %s - %s (%s)\n"
                            + "    Professor: %s\n"
                            + "    Course Type: %s\n"
                            + "    Credits: %d (Cost: $%,d)\n"
                            + "    Grade: %.2f (%s)\n\n",
                            course.getCourseNumber(),
                            course.getName(),
                            course.getCredits() + " credits",
                            professor.getFullName(),
                            course.isCore() ? "Core" : "Elective",
                            course.getCredits(),
                            course.getCoursePrice(),
                            grade,
                            letterGrade);

                    totalGradePoints += grade * course.getCredits();
                    totalCredits += course.getCredits();
                    totalTuition += course.getCoursePrice();
                }

                if (totalCredits > 0) {
                    double gpa = totalGradePoints / totalCredits;
                    System.out.printf("Semester Summary:\n"
                            + "  Total Credits: %d\n"
                            + "  Semester GPA: %.2f\n"
                            + "  Total Tuition: $%,d\n",
                            totalCredits,
                            gpa,
                            totalTuition);
                }
            }
            System.out.println("================================================================");
        }

        // Print final statistics
        System.out.printf("\nFINAL STATISTICS:\n"
                + "Total Course Registrations: %d\n"
                + "Department Revenue: $%,d\n",
                totalRegistrations,
                department.calculateRevenuesBySemester("Fall 2024"));
    }

    public static void main(String[] args) {
        UniversityManagementSystem ums = new UniversityManagementSystem("Information Systems");

        // Setup the university system
        ums.setupCourseCatalog();
        ums.setupFaculty();
        ums.setupStudents();
        ums.setupCourseSchedule();
        ums.registerStudents();

        // Generate the semester report
        ums.generateSemesterReport();
    }
}
