package info5100.university.example.Persona;

import java.util.ArrayList;

public class PersonDirectory {
    private ArrayList<Person> personlist;
    
    public PersonDirectory() {
        personlist = new ArrayList<>();
    }
    
    public Person newPerson(String id) {
        Person p = new Person(id);
        personlist.add(p);
        return p;
    }

    // Add new method to create person with full details
    public Person newPerson(String id, String firstName, String lastName) {
        Person p = new Person(id, firstName, lastName);
        personlist.add(p);
        return p;
    }
    
    public Person findPerson(String id) {
        for (Person p : personlist) {
            if (p.getPersonId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}