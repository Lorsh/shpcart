/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emil
 */
public class Database {
    static private ArrayList<Customer> profiles = new ArrayList<Customer>();
    private static Database instance;    
    
    private final String fileName = "userBase.txt";
    
    private Database () throws FileNotFoundException {
    try {
    FileInputStream fhi = new FileInputStream(fileName);
    ObjectInputStream ois = new ObjectInputStream(fhi);
    profiles = (ArrayList<Customer>) ois.readObject();
    ois.close();
    }
    catch (IOException e) {
        Customer cust = new Customer("guest","guest");
        profiles.add(cust);
    
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
    public static Database getInstance()  {
    if (instance == null) {
    try {
    instance = new Database();
    } catch (FileNotFoundException ex) {
    System.err.println("Error");
    }
    }
    return instance;
    }
    public void update() throws IOException{
    
    FileOutputStream fho = new FileOutputStream (fileName);
    ObjectOutputStream oos = new ObjectOutputStream (fho);
    oos.writeObject(profiles);
    oos.close();
    }
    
    public static ArrayList<Customer> getProfiles() {
    return profiles;
    }
    
    public static void setProfiles(ArrayList<Customer> profiles) {
    Database.profiles = profiles;
    }
    
    public String getFileName() {
    return fileName;
    }
    
    public boolean checkCustomerExist(String user){
    for (Customer prof : profiles){
    if (prof.getName().equals(user)) {
    return true;
    }
    
    }
    return false;
    }
    
    public boolean authenticateCustomer(String user, String pass){
    Customer prof = new Customer (user,pass);
    return profiles.contains(prof);
    }
    
    public Customer getProfile (String user, String pass) {
    if (checkCustomerExist(user)){
    Customer prof = new Customer (user,pass);
    int index= profiles.indexOf(prof);
    return profiles.get(index);
    }
    else {
    return null;
    }
    }
    
    public void addProfileToDB(Customer prof) throws IOException {
    if (!checkCustomerExist(prof.getName())){
    profiles.add(prof);
    update();
    if (checkCustomerExist(prof.getName())) {
    System.out.println("Customer was successfuly created");
    }
    else {
    System.err.println("user " + prof.getName() + " was not created");
    }
    }
    else {
    System.err.println("Customer already exists");
    }
    }
    
    public void removeProfileFromDB (String usr,String pass) throws IOException,ArrayIndexOutOfBoundsException {
    profiles.remove(profiles.indexOf(getProfile(usr,pass)));
    update();
    if (!checkCustomerExist(usr)) {
    System.out.println("user " + usr + " was successfuly deleted");
    } else {
    System.err.println("user " + usr + " was not deleted");
    }
    }
    
    
    
}
