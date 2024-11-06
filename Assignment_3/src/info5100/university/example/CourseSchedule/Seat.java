package info5100.university.example.CourseSchedule;

public class Seat {
    Boolean occupied;
    CourseOffer courseoffer;
    
    public Seat(CourseOffer co) {
        courseoffer = co;
        occupied = false;
    }
    
    public Boolean isOccupied() {
        return occupied;
    }
    
    public CourseOffer getCourseoffer() {
        return courseoffer;
    }
    
    public void setOccupied(Boolean b) {
        occupied = b;
    }
}