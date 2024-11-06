/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

public class Course {
    String number;
    String name;
    int credits;
    int price = 1500; // price per credit hour
    boolean isCore;

    public Course(String n, String numb, int ch, boolean isCore) {
        name = n;
        number = numb;
        credits = ch;
        this.isCore = isCore;
    }

    public String getCourseNumber() {
        return number;
    }

    public int getCredits() {
        return credits;
    }
    
    public String getName() {
        return name;
    }

    public int getCoursePrice() {
        return price * credits;
    }
    
    public boolean isCore() {
        return isCore;
    }
        
    public int getPricePerCredit() {
        return price;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s (%d credits, %s)",
            number, name, credits, isCore ? "Core" : "Elective");
    }
}