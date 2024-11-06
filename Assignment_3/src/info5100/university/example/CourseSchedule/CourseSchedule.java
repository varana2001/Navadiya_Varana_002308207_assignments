package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import java.util.ArrayList;

public class CourseSchedule {
    CourseCatalog coursecatalog;
    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog c) {
        semester = s;
        coursecatalog = c;
        schedule = new ArrayList<>();
    }

    public CourseOffer newCourseOffer(String n) {
        Course c = coursecatalog.getCourseByNumber(n);
        if (c == null) return null;
        
        CourseOffer co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    public ArrayList<CourseOffer> getCourseOffers() {
        return schedule;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {
            sum = sum + co.getTotalCourseRevenues();
        }
        return sum;
    }
}