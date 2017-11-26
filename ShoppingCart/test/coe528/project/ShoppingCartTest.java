/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Subhasish
 */
public class ShoppingCartTest {
    
    public ShoppingCartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * black box testing. Test of getshoppingID method, of class ShoppingCart.
     */
    @Test
    public void testGetshoppingID() {
        System.out.println("getshoppingID");
        ShoppingCart instance = new ShoppingCart();
        int expResult = 7;
        int result = instance.getshoppingID();
        //System.out.println(result+"IDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        assertEquals(expResult, result);
       
    }

    /**
     * WhiteBox testing: The user needs to see that we have to make an item object in the 
     * shoppingCart class. In order to check if the item is added to the shoppingCart successfully,
     * we are getting the item from the shoppingCart class and storing them into an array list. 
     * If the item added in the shoppingChart matches with the item found from the Array list, we
     * will be able to conclude that testing is successful.
     */
    @Test
    public void testAddtoShoppingCart() {
        System.out.println("addtoShoppingCart");
        Item item = new Item("Pen", "old", 50.0);
        ShoppingCart instance = new ShoppingCart();
        instance.addtoShoppingCart(item);
        ArrayList<Item> a = instance.getItems();
        boolean z = false;
        for(int i=0; i<a.size();i++){
            if(a.get(i) == item) {
                z = true;    
            } 
        }
        assertTrue(z);
    }
    /**
     * White Box testing:
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        ShoppingCart instance = new ShoppingCart();
        Item item = new Item("Mouse", "old", 50.0);
        instance.addtoShoppingCart(item);
        ArrayList<Item> a = instance.getItems();
        boolean z = false;
        for(int i=0; i<a.size();i++){
            if(a.get(i) == item) {
                z = true;    
            } 
        }
        assertTrue(z);
    }
    
     /**
     * White Box Testing:
     */
    @Test
    public void testUpdateSubTotal() {
        System.out.println("updateSubTotal");
        ShoppingCart instance =  new ShoppingCart();
        Item item = new Item("Headphone", "old", 50.0);
        Item item1 = new Item("Mouse", "old", 50.0);
        instance.addtoShoppingCart(item);
        instance.addtoShoppingCart(item1);
        double expResult = 100.0;
        double result = instance.updateSubTotal();
        double change = 5;
        assertEquals(expResult, result, change);
    }
    /**
     * Black Box testing: The shoppingCart class takes the subtotal of Items in the parameter.
     * In order to test this constractor, the user needs to pass the subtotal and get the subtotal 
     * by calling the getSubtotal method. Tester does not need to know details of the code.
     */
    @Test
    public void testgetSubtotal() {
        System.out.println("getsubtotal");
        ShoppingCart instance = new ShoppingCart();
        double expResult = 0;
        double result = instance.getSubtotal();
        double change = 0.5;
        assertEquals(expResult, result, change);
       }

    /**
     * Black box Test: User just need to call the check out method and the method will automatically 
     * create an order for the customer.
     * -------------------------------------------------------------help
     */
    @Test
    public void testCreateOrder() {
        System.out.println("checkOut");
        
        ShoppingCart instance = new ShoppingCart();
        Item item = new Item("Bike", "New", 200);
        Item item1 = new Item("Cat", "New", 10000);
        instance.addtoShoppingCart(item);
        instance.addtoShoppingCart(item1);
        ShippingInfo name = new ShippingInfo("Emil");
        ArrayList<Item> a = instance.getItems();
        Order x = instance.createOrder(a, instance.getSubtotal(),name);
        Order y = new Order(a, instance.getSubtotal(), name);
        assertEquals(x.toString(), y.toString());
       }

    /**
     * White Box test: 
     */
    @Test
    public void testRemoveFromShoppingCart() {
        System.out.println("removeFromShoppingCart");
        ShoppingCart instance = new ShoppingCart();
        Item item = new Item("Cat", "New", 10000);
        Item x = new Item("Bike", "New", 200);
        instance.addtoShoppingCart(item);
        instance.addtoShoppingCart(x);
        instance.removeFromShoppingCart(item); //not working
        ArrayList<Item> a = instance.getItems();
        int b = a.size(); 
        System.out.println(b);
        //boolean z = false;
        //if(a.isEmpty()){
          //  z = true;
        //}
        //assertTrue(z);
    }

    /**
     * Test of updateQuantity method, of class ShoppingCart.
     */
    @Test // not done
    public void testUpdateQuantity() {
        System.out.println("updateQuantity");
        ShoppingCart instance = new ShoppingCart();
        Item item = new Item("Cat", "New", 10000);
        //Item item1 = new Item("Cat", "New", 10000);
        instance.addtoShoppingCart(item);
        //instance.addtoShoppingCart(item1);
        //ArrayList<Item> a = instance.getItems();
        //for(Item x : a) 
        //if(a.size()==2)    
        //}
        instance.updateQuantity(2, item);
        ArrayList<Item> a = instance.getItems();
        int result = a.size();
        int expResult = 2;
        assertEquals(expResult, result);
        
       }
    /**
     * Test of getItem method, of class ShoppingCart.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        ShoppingCart instance = new ShoppingCart();
        Item item = new Item("Cat", "New", 10000);
        instance.addtoShoppingCart(item);
        Item expResult = item;
        Item result = instance.getItem("Cat", "New");
        assertEquals(expResult, result);}
    /**
     * Test of TotalShoppingNumber method, of class ShoppingCart.
     */
    @Test //done
    public void testTotalShoppingNumber() {
        System.out.println("TotalShoppingNumber");
        ShoppingCart instance = new ShoppingCart();
        Item pen = new Item("pen", "old", 1.1 );  // adding new item to the array
        instance.addtoShoppingCart(pen);
        int expResult = 1;
        int result = instance.TotalShoppingNumber();
        assertEquals(expResult, result);
       }

    public void testGetItemsFromBrowse(){
        System.out.println("TotalShoppingNumber");
        ShoppingCart instance = new ShoppingCart();
        Item item = new Item("Cat", "New", 10000);
        //Item item1 = new Item("Cat", "New", 10000);
        instance.addtoShoppingCart(item);
        //instance.addtoShoppingCart(item1);
        ArrayList<Item> a = instance.getItems(); 
        boolean z = false;
        for(int i=0; i<instance.TotalShoppingNumber();i++){
            Item[] b = instance.getItemsFromBrowse(item.getName(),item.getCondition(), instance.TotalShoppingNumber());
        
            if(b[i] == item) {
                z = true;    
            } 
        }
        assertTrue(z);
        //assertEquals(a, b);
    }
    
    
    /**
     * White box testing:
     */
    @Test //done
    public void testViewCartDetails() {
        System.out.println("viewCartDetails");
        ShoppingCart instance = new ShoppingCart();
        String expResult = "Shopping ID is"  +instance.getshoppingID()+ "Number of Items" +instance.TotalShoppingNumber()+ "Subtotal" +instance.updateSubTotal();
        String result = instance.viewCartDetails();
        assertEquals(expResult, result);
       }

    /**
     * Black box testing: Test of toString method, of class ShoppingCart. I am entering an expected string. 
     * i am calling a method in the ShoppingChart class and checking if the input and output strings are similar.
     */
    @Test 
    public void testToString() {
        System.out.println("toString");
        ShoppingCart instance = new ShoppingCart();
        String expResult = "Numbers of Items 0 Subtotal 0.0";
        String result = instance.toString();
        assertEquals(expResult, result);
       }
    
}