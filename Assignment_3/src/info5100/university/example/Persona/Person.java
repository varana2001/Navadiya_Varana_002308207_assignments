package info5100.university.example.Persona;

public class Person {
    String id;
    String firstName;
    String lastName;
    
    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getPersonId() {
        return id;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public Person(String id) {
        this.id = id;
    }
}