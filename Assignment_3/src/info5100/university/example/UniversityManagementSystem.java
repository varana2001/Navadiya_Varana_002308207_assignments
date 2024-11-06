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
        System.out.println("Added Core Course: Applied Engineering and Development (INFO5100)");

        // Elective courses
        courseCatalog.newCourse("Cloud Computing", "INFO6300", 4, false);
        System.out.println("Added Elective Course: Cloud Computing (INFO6300)");

        courseCatalog.newCourse("Data Science Engineering", "INFO6400", 4, false);
        System.out.println("Added Elective Course: Data Science Engineering (INFO6400)");

        courseCatalog.newCourse("Cyber Security", "INFO6500", 4, false);
        System.out.println("Added Elective Course: Cyber Security (INFO6500)");

        courseCatalog.newCourse("AI & Machine Learning", "INFO6600", 4, false);
        System.out.println("Added Elective Course: AI & Machine Learning (INFO6600)");

        courseCatalog.newCourse("Web Design & User Experience", "INFO6150", 4, false);
        System.out.println("Added Elective Course: Web Design & User Experience (INFO6150)");

        courseCatalog.newCourse("Program Structure & Algorithms", "INFO6205", 4, false);
        System.out.println("Added Elective Course: Program Structure & Algorithms (INFO6205)");

        courseCatalog.newCourse("Database Management Systems", "INFO6210", 4, false);
        System.out.println("Added Elective Course: Database Management Systems (INFO6210)");

        courseCatalog.newCourse("Web Development Tools & Methods", "INFO6250", 4, false);
        System.out.println("Added Elective Course: Web Development Tools & Methods (INFO6250)");

        courseCatalog.newCourse("Smartphone-based Web Development", "INFO6350", 4, false);
        System.out.println("Added Elective Course: Smartphone-based Web Development (INFO6350)");
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
            Person facultyPerson = department.getPersonDirectory().newPerson(data[0], data[1], data[2]);
            facultyDirectory.newFacultyProfile(facultyPerson);
            System.out.printf("Added Faculty: %s %s (ID: %s)\n", data[1], data[2], data[0]);
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
            Person studentPerson = department.getPersonDirectory().newPerson(data[0], data[1], data[2]);
            studentDirectory.newStudentProfile(studentPerson);
            System.out.printf("Added Student: %s %s (ID: %s)\n", data[1], data[2], data[0]);
        }
    }

    public void setupCourseSchedule() {
        String[] courseSchedules = {
            "INFO5100-SEC1",
            "INFO5100-SEC2",
            "INFO6150-SEC1",
            "INFO6205-SEC1",
            "INFO6210-SEC1",
            "INFO6250-SEC1",
            "INFO6350-SEC1",
            "INFO6300-SEC1",
            "INFO6400-SEC1",
            "INFO6500-SEC1"
        };

        Map<FacultyProfile, Integer> facultyLoadCount = new HashMap<>();
        FacultyProfile[] faculty = facultyDirectory.getFacultyList().toArray(new FacultyProfile[0]);
        for (FacultyProfile fp : faculty) {
            facultyLoadCount.put(fp, 0);
        }

        for (String scheduleItem : courseSchedules) {
            String[] parts = scheduleItem.split("-");
            String courseNumber = parts[0];

            CourseOffer offer = courseSchedule.newCourseOffer(courseNumber);
            if (offer != null) {
                offer.generatSeats(30);
                System.out.printf("Created Course Offer: %s - Section: %s\n", courseNumber, parts[1]);

                FacultyProfile selectedFaculty = getLeastLoadedFaculty(facultyLoadCount);
                offer.AssignAsTeacher(selectedFaculty);
                facultyLoadCount.put(selectedFaculty, facultyLoadCount.get(selectedFaculty) + 1);

                System.out.printf("Assigned Professor: %s to Course: %s - Section: %s\n",
                        selectedFaculty.getPerson().getFullName(), courseNumber, parts[1]);

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

            CourseOffer coreSection = getAvailableCoreSection();
            if (coreSection != null) {
                courseLoad.registerStudentInClass(coreSection);
                System.out.printf("Registered Student: %s (ID: %s) in Core Course: %s - %s\n",
                        student.getPerson().getFullName(), student.getPerson().getPersonId(),
                        coreSection.getCourse().getCourseNumber(), coreSection.getSection());
                totalRegistrations++;
            }

            int numElectives = 1 + (int) (Math.random() * 2);
            for (int i = 0; i < numElectives; i++) {
                CourseOffer electiveOffer = getRandomElectiveOffer(offers);
                if (electiveOffer != null) {
                    courseLoad.registerStudentInClass(electiveOffer);
                    System.out.printf("Registered Student: %s (ID: %s) in Elective Course: %s - %s\n",
                            student.getPerson().getFullName(), student.getPerson().getPersonId(),
                            electiveOffer.getCourse().getCourseNumber(), electiveOffer.getSection());
                    totalRegistrations++;
                }
            }
        }

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
        System.out.println("\n-------------------------- SEMESTER REPORT - Fall 2024-------------------------- \n");

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

        System.out.println("\n\nCOURSE CATALOG:");
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
            System.out.println("------------------------------------------------");
        }

        System.out.printf("\nFINAL STATISTICS:\n"
                + "Total Course Registrations: %d\n"
                + "Department Revenue: $%,d\n",
                totalRegistrations,
                department.calculateRevenuesBySemester("Fall 2024"));
    }

    public static void main(String[] args) {
        UniversityManagementSystem ums = new UniversityManagementSystem("Information Systems");

        ums.setupCourseCatalog();
        ums.setupFaculty();
        ums.setupStudents();
        ums.setupCourseSchedule();
        ums.registerStudents();

        ums.generateSemesterReport();
    }
}
