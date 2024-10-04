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
    searchResults.clear();  // Clear previous search results
    String lowerSearchInput = searchInput.toLowerCase();

    for (PersonProfile p : profile) {
        if ((p.getFirstName() != null && p.getFirstName().toLowerCase().contains(lowerSearchInput)) ||
            (p.getLastName() != null && p.getLastName().toLowerCase().contains(lowerSearchInput)) ||
            (p.getHomeStreetAddress() != null && p.getHomeStreetAddress().toLowerCase().contains(lowerSearchInput)) ||
            (p.getWorkStreetAddress() != null && p.getWorkStreetAddress().toLowerCase().contains(lowerSearchInput))) {
            searchResults.add(p);  
        }
    }
    }
}
