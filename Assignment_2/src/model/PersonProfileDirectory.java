/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author varananavadiya
 */
public class PersonProfileDirectory {

    private ArrayList<PersonProfile> personProfiles;

    public PersonProfileDirectory() {
        this.personProfiles = new ArrayList<>();
    }

    public ArrayList<PersonProfile> getPersonProfiles() {
        return personProfiles;
    }

    public void setPersonProfiles(ArrayList<PersonProfile> personProfiles) {
        this.personProfiles = personProfiles;
    }

    // Method to add a new person profile
    public PersonProfile addPersonProfile() {
        PersonProfile p = new PersonProfile();
        personProfiles.add(p);
        return p;
    }

    // Method to delete a person profile
    public void deletePersonProfile(PersonProfile personProfile) {
        personProfiles.remove(personProfile);
    }

    // Method to search for a person by first name, last name, or street address
    public PersonProfile searchPersonProfile(String searchTerm) {
        for (PersonProfile p : personProfiles) {
            if (p.getFirstName().equalsIgnoreCase(searchTerm)
                    || p.getLastName().equalsIgnoreCase(searchTerm)
                    || p.getHomeAddress().getStreetAddress().equalsIgnoreCase(searchTerm)
                    || p.getWorkAddress().getStreetAddress().equalsIgnoreCase(searchTerm)
                    ) {
                return p;
            }
        }
        return null; // No match found
    }
}
