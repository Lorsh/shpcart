package coe528.project;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShippingInfo implements Serializable {

    //private int shippingID;

    //private String shippngType;

    //private int shippingCost;

    //private int shippingRegionID;

    //private Calendar expectedArrival;
    
    private String addressStreet = "Empty";
    
    private String addressCity = "Empty";
    
    private String addressProvince = "Empty";
    
    private String addressPostal = "Empty";
    
    private String name;
    
    
    public ShippingInfo(String name) {
        this.name = name;
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
        String n = null, aS = null, aC = null, aPo = null;
        String regxn = ("^([A-Za-z]+) ?([A-za-z]+)?");
        Pattern ptrnn = Pattern.compile(regxn);
        String regxaS = ("[0-9A-Za-z\\.\\-\\# ]+");
        Pattern ptrnaS = Pattern.compile(regxaS);
        String regxaC = ("^([A-Za-z\\.]+) ?([A-za-z\\.]+)?");
        Pattern ptrnaC = Pattern.compile(regxaC);
        String regxaPo = ("^([A-Za-z0-9]+) ?([A-za-z0-9]+)?");
        Pattern ptrnaPo = Pattern.compile(regxaPo);
        Matcher matcher;
        
        
        
        
        System.out.println("What would you like to change?");
        System.out.println("1. Name\n2. Address\n3. Name and Address\n4. Cancel updating shipping info.");
        System.out.print("Please enter a number: ");
        SelectBreak:
        while(!(i >= 1 && i <= 4)){
            while(!s.hasNextInt()){
                s.next();
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
            case 1 :
                System.out.print("Please enter full name: ");
                //n = s.next();
                n = s.nextLine();
                matcher = ptrnn.matcher(n);
                while(!matcher.matches()){
                    n = s.nextLine();
                    matcher = ptrnn.matcher(n);
                    if(!matcher.matches()){
                        System.out.print("Invalid entry. Please try again: ");
                    }
                    else{
                        break;
                    }
                }
                break;
            case 2 :
                System.out.print("Please enter street address: ");
                //aS = s.nextLine();
                aS = s.nextLine();
                matcher = ptrnaS.matcher(aS);
                while(!matcher.matches()){
                    aS = s.nextLine();
                    matcher = ptrnaS.matcher(aS);
                    if(!matcher.matches()){
                        System.out.print("Invalid entry. Please try again: ");
                    }
                    else{
                        break;
                    }
                }
                System.out.print("Please enter City: ");
                //aC = s.next();
                aC = s.nextLine();
                matcher = ptrnaC.matcher(aC);
                while(!matcher.matches()){
                    aC = s.nextLine();
                    matcher = ptrnaC.matcher(aC);
                    if(!matcher.matches()){
                        System.out.print("Invalid entry. Please try again: ");
                    }
                    else{
                        break;
                    }
                }
                System.out.print("Please enter postal code: ");
                //aPo = s.nextLine(); 
                aPo = s.nextLine();
                matcher = ptrnaPo.matcher(aPo);
                while(!matcher.matches()){
                    aPo = s.nextLine();
                    matcher = ptrnaPo.matcher(aPo);
                    if(!matcher.matches()){
                        System.out.print("Invalid entry. Please try again: ");
                    }
                    else{
                        break;
                    }
                }
                break;
            case 3 :
                System.out.print("Please enter full name: ");
                //n = s.next();
                n = s.nextLine();
                matcher = ptrnn.matcher(n);
                while(!matcher.matches()){
                    n = s.nextLine();
                    matcher = ptrnn.matcher(n);
                    if(!matcher.matches()){
                        System.out.print("Invalid entry. Please try again: ");
                    }
                    else{
                        break;
                    }
                }
                System.out.print("Please enter street address: ");
                //aS = s.nextLine();
                aS = s.nextLine();
                matcher = ptrnaS.matcher(aS);
                while(!matcher.matches()){
                    aS = s.nextLine();
                    matcher = ptrnaS.matcher(aS);
                    if(!matcher.matches()){
                        System.out.print("Invalid entry. Please try again: ");
                    }
                    else{
                        break;
                    }
                }
                System.out.print("Please enter City: ");
                //aC = s.next();
                aC = s.nextLine();
                matcher = ptrnaS.matcher(aC);
                while(!matcher.matches()){
                    aC = s.nextLine();
                    matcher = ptrnaS.matcher(aC);
                    if(!matcher.matches()){
                        System.out.print("Invalid entry. Please try again: ");
                    }
                    else{
                        break;
                    }
                }
                System.out.print("Please enter postal code: ");
                //aPo = s.nextLine(); 
                aPo = s.nextLine();
                matcher = ptrnaPo.matcher(aPo);
                while(!matcher.matches()){
                    aPo = s.nextLine();
                    matcher = ptrnaPo.matcher(aPo);
                    if(!matcher.matches()){
                        System.out.print("Invalid entry. Please try again: ");
                    }
                    else{
                        break;
                    }
                }
                break;
            case 4:
                break;                    
        }
        
        if(!(i == 4)){
            String cont;
            boolean cont2;
            System.out.println("Review info:");
            
            if(i == 1){
                System.out.println("Name: "+n+"\tStreet Address: "+this.addressStreet+"\tCity: "+this.addressCity+"\t\tPostal Code: "+this.addressPostal);
                System.out.print("Is the above info OK? Press Y/N (y/n): ");
                while(!s.hasNext("[NnYy]")){
                    s.next();
                }
                cont = s.next();
                if(cont.equals("Y") || cont.equals("y")){
                    this.setName(n);
                    System.out.println("Shipping information successfully updated!");
                }
            }
            if(i == 2){
                System.out.println("Name: "+this.name+"\tStreet Address: "+aS+"\tCity: "+aC+"\tPostal Code: "+aPo);
                System.out.print("Is the above info OK? Press Y/N (y/n): ");
                while(!s.hasNext("[NnYy]")){
                    s.next();
                }
                cont = s.next();
                if(cont.equals("Y") || cont.equals("y")){
                    this.setAddressStreet(aS);
                    this.setAddressCity(aC);
                    this.setAddressPostal(aPo);
                    System.out.println("Shipping information successfully updated!");
                }
            }
            if(i == 3){
                System.out.println("Name: "+n+"\tStreet Address: "+aS+"\tCity: "+aC+"\tPostal Code: "+aPo);
                System.out.print("Is the above info OK? Press Y/N (y/n): ");
                while(!s.hasNext("[NnYy]")){
                    s.next();
                }
                cont = s.next();
                if(cont.equals("Y") || cont.equals("y")){
                    this.setName(n);
                    this.setAddressStreet(aS);
                    this.setAddressCity(aC);
                    this.setAddressPostal(aPo);
                    System.out.println("Shipping information successfully updated!");
                }
            }
            /**
            System.out.println("Name: "+n+"\tStreet Address: "+aS+"\tCity: "+aC+"\tPostal Code: "+aPo);
            System.out.print("Is the above info OK? Press Y/N (y/n): ");
            while(!s.hasNext("[NnYy]")){
                s.next();
            }
            cont = s.next();
            
            if(cont.equals("Y") || cont.equals("y")){
                this.setName(n);
                this.setAddressStreet(aS);
                this.setAddressCity(aC);
                this.setAddressPostal(aPo);
                System.out.println("Shipping information successfully updated!");
            }
            else{
                /**
                if(i == 1){
                    this.setName("Empty");
                }
                if(i == 2){
                    this.setAddressStreet("Empty");
                    this.setAddressCity("Empty");
                    this.setAddressPostal("Empty");
                }
                if(i == 3){
                    this.setName("Empty");
                    this.setAddressStreet("Empty");
                    this.setAddressCity("Empty");
                    this.setAddressPostal("Empty");
                }
                 
            }
            **/
        }
        else{
            System.out.println("Exiting shipping info update...");
        }         
    }    
        public boolean repOK(){
        String empty = "Empty";
        if (addressStreet.equals(empty) || addressCity.equals(empty) || addressProvince.equals(empty) || addressPostal.equals(empty)) {
            return false;
        }
        else return true;
    }
    public String toString() {
        return name+"\n"+addressStreet+"\n"+addressCity+", "+addressProvince+"\n"+addressPostal;
    }    
}
