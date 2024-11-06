package info5100.university.example.CourseSchedule;

import java.util.ArrayList;

public class CourseLoad {
    String semester;
    ArrayList<SeatAssignment> seatassignments; //each represent 1 course registration
    
    public CourseLoad(String s){
        seatassignments = new ArrayList();
        semester = s;
    }
        public SeatAssignment newSeatAssignment(CourseOffer co) {
        Seat seat = co.getEmptySeat();
        if (seat == null) return null;
        
        SeatAssignment sa = new SeatAssignment(seat);
        seatassignments.add(sa);
        return sa;
    }

    public void registerStudentInClass(CourseOffer co) {
        newSeatAssignment(co);
    }

    public ArrayList<SeatAssignment> getSeatassignments() {
        return seatassignments;
    }

            
}
