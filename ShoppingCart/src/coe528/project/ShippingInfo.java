package coe528.project;

import java.util.Calendar;
import java.util.Scanner;

public class ShippingInfo {

   // private int shippingID;

    //private String shippngType;

    //private int shippingCost;

    //private int shippingRegionID;

    //private Calendar expectedArrival;
    
    private String addressStreet;
    
    private String addressCity;
    
    private final String addressProvince = "Ontario";
    
    private String addressPostal;
    
    private String name;
    
    
    public ShippingInfo() {
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public String getAddressPostal() {
        return addressPostal;
    }

    public void setAddressPostal(String addressPostal) {
        this.addressPostal = addressPostal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateShippingInfo() {
        Scanner s = new Scanner(System.in);
        int i = -1;
        String n = null, aS = null, aC = null, aP = null, aPo = null;
        
        System.out.println("What would you like to change?");
        System.out.println("1. Name\n2. Address\n3. Name and Address\n4. Cancel updating shipping info.");
        System.out.print("Please enter a number: ");
        SelectBreak:
        while(!(i >= 1 && i <= 4)){
            while(!s.hasNextInt()){
                i = s.nextInt();
            }
            i = s.nextInt();
            if(!(i >= 1 && i <= 3)){
                System.out.print("Invalid entry. Please try again: ");
            }
            else{
                break SelectBreak;
            }
        }
        switch(i){
            case '1' :
                System.out.print("Please enter full name: ");
                n = s.next();
                break;
            case '2' :
                System.out.print("Please enter street address: ");
                aS = s.next();
                System.out.print("Please enter City: ");
                aC = s.next();
                System.out.print("Please enter postal code: ");
                aPo = s.next(); 
                break;
            case '3' :
                System.out.print("Please enter full name: ");
                n = s.next();
                System.out.print("Please enter street address: ");
                aS = s.next();
                System.out.print("Please enter City: ");
                aC = s.next();
                System.out.print("Please enter postal code: ");
                aPo = s.next(); 
                break;
            case '4' :
                break;                    
        }
        
        if(!(i == 4)){
            String cont;
            boolean cont2;
            
            System.out.println("Review info:");
            System.out.println("Name: "+n+"\tStreet Address: "+aS+"\tCity: "+aC+"\tPostal Code: "+aPo);
            System.out.print("Is the above info OK? Press Y/N (y/n): ");
            while(!s.hasNext("[NnYy]")){
                s.next();
            }
            cont = s.next();
            
            if(cont.equals("Y") || cont.equals("y")){
                setName(n);
                setAddressStreet(aS);
                setAddressCity(aC);
                setAddressPostal(aPo);
                System.out.println("Shipping information successfully updated!");
            }
        }
        else{
            System.out.println("Exiting shipping info update...");
        }   
            
    }    
            
    public String toString() {
        return name+"\n"+addressStreet+"\n"+addressCity+", "+addressProvince+"\n"+addressPostal;
    }    
}
