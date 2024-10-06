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

    private ArrayList<PersonProfile> profile;
    private ArrayList<PersonProfile> searchResults;

    public ArrayList<PersonProfile> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<PersonProfile> searchResults) {
        this.searchResults = searchResults;
    }
    
    public PersonProfileDirectory(){
        this.profile=new ArrayList<PersonProfile>();
        this.searchResults = new ArrayList<>();
    }

    public ArrayList<PersonProfile> getProfile() {
        return profile;
    }

    public void setProfile(ArrayList<PersonProfile> profile) {
        this.profile = profile;
    }
    
    public PersonProfile addProfile(){
        PersonProfile p = new PersonProfile();
        profile.add(p);
        return p;
    }
    
    public void addProfile(PersonProfile newProfile) {
    profile.add(newProfile);
}   
    
    public void deleteProfile(PersonProfile aProfile)
    {
        profile.remove(aProfile);
    }
    
    public void searchProfile(String searchInput) {
        searchResults.clear();  
        String lowerSearchInput = searchInput.toLowerCase();  

        for (PersonProfile p : profile) {
            boolean firstNameMatch = p.getFirstName() != null && p.getFirstName().toLowerCase().contains(lowerSearchInput);
            boolean lastNameMatch = p.getLastName() != null && p.getLastName().toLowerCase().contains(lowerSearchInput);


            boolean homeStreetMatch = p.getHomeAddress() != null &&
                                      p.getHomeAddress().getStreetAddress() != null &&
                                      p.getHomeAddress().getStreetAddress().toLowerCase().contains(lowerSearchInput);

            boolean workStreetMatch = p.getWorkAddress() != null &&
                                      p.getWorkAddress().getStreetAddress() != null &&
                                      p.getWorkAddress().getStreetAddress().toLowerCase().contains(lowerSearchInput);

            if (firstNameMatch || lastNameMatch || homeStreetMatch || workStreetMatch) {
                searchResults.add(p);  
                }
            }
    }
}
