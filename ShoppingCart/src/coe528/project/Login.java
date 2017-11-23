/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Emil
 */
/**
 *
 * @author Emil
 */
public class Login {
    private Customer prof = null;
    
    
    public Login (String username,String password){
    Database db;
    db = Database.getInstance();    
    if (db.authenticateCustomer(username,password)) {
    System.out.println("Username was found. Please wait until we log you in...");
    prof = db.getProfile(username,password);
    System.out.println("Logged in as: " + prof.getName());
    }
    else {
    System.err.println("User credentials are invalid. Please make sure you typed your information correctly.");
    }
    
    }
    
    public boolean condition () {
        if (prof != null) {
        return true;
        }
        else return false;
    
    }
    public Customer getProf(){
        return prof;
    }
    
    public void setProf(Customer prof){
        this.prof = prof;
    }
    
    
    
}
