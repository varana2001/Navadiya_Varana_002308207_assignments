package info5100.university.example.CourseCatalog;

import java.util.ArrayList;

public class CourseCatalog {
    private ArrayList<Course> courseList;

    public CourseCatalog() {
        courseList = new ArrayList<>();
    }

    public Course newCourse(String name, String number, int credits, boolean isCore) {
        Course c = new Course(name, number, credits, isCore);
        courseList.add(c);
        return c;
    }

    public Course getCourseByNumber(String n) {
        for (Course c : courseList) {
            if (c.getCourseNumber().equals(n)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    // Method to get all core courses
    public ArrayList<Course> getCoreCourses() {
        ArrayList<Course> coreCourses = new ArrayList<>();
        for (Course c : courseList) {
            if (c.isCore()) {
                coreCourses.add(c);
            }
        }
        return coreCourses;
    }

    // Method to get all elective courses
    public ArrayList<Course> getElectiveCourses() {
        ArrayList<Course> electiveCourses = new ArrayList<>();
        for (Course c : courseList) {
            if (!c.isCore()) {
                electiveCourses.add(c);
            }
        }
        return electiveCourses;
    }

    // Method to print course catalog
    public void printCourseCatalog() {
        System.out.println("\n=== COURSE CATALOG ===\n");
        
        System.out.println("CORE COURSES:");
        System.out.println("-------------");
        for (Course c : getCoreCourses()) {
            printCourseDetails(c);
        }
        
        System.out.println("\nELECTIVE COURSES:");
        System.out.println("-----------------");
        for (Course c : getElectiveCourses()) {
            printCourseDetails(c);
        }
    }

    private void printCourseDetails(Course c) {
        System.out.printf("%s - %s\n" +
                         "Credits: %d\n" +
                         "Cost per Credit: $%,d\n" +
                         "Total Course Cost: $%,d\n\n",
            c.getCourseNumber(),
            c.getName(),
            c.getCredits(),
            c.getPricePerCredit(),
            c.getCoursePrice());
    }
}