package info5100.university.example.CourseSchedule;

public class SeatAssignment {
    double grade;
    Seat seat;
    
    public SeatAssignment(Seat s) {
        seat = s;
        seat.setOccupied(true);
    }
    
    public void assignGrade(double g) {
        grade = g;
    }
    
    public double getGrade() {
        return grade;
    }
    
    public Seat getSeat() {
        return seat;
    }
}
