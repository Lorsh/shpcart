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
     * Test of getshoppingID method, of class ShoppingCart.
     */
    @Test
    public void testGetshoppingID() {
        System.out.println("getshoppingID");
        ShoppingCart instance = new ShoppingCart(123, 50);;
        int expResult = 123;
        int result = instance.getshoppingID();
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
        Item item = new Item("Pen", "old", 110, 50.0);
        ShoppingCart instance = new ShoppingCart(11, 50.0);
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
        ShoppingCart instance = new ShoppingCart(11, 50.0);
        Item item = new Item("Mouse", "old", 110, 50.0);
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
        ShoppingCart instance =  new ShoppingCart(11, 50.0);
        Item item = new Item("Headphone", "old", 110, 50.0);
         new ShoppingCart(11, 50.0);
        Item item1 = new Item("Mouse", "old", 111, 50.0);
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
        ShoppingCart instance = new ShoppingCart(11, 50.0);
        double expResult = 50.0;
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
        //Order y = new Order(Item a, );
        ShoppingCart instance = new ShoppingCart(11, 50);
        //Order x = instance.createOrder();
        //assertEquals(y, y);
       }

    /**
     * White Box test: 
     */
    @Test
    public void testRemoveFromShoppingCart() {
        System.out.println("removeFromShoppingCart");
        ShoppingCart instance = new ShoppingCart(11, 50);
        Item item = new Item("Headphone", "old", 110, 50.0);
        instance.addtoShoppingCart(item);
        instance.removeFromShoppingCart(item);
        ArrayList<Item> a = instance.getItems();
        
        boolean z = false;
        if(a.isEmpty()){
            z = true;
        }
        assertTrue(z);
    }

    /**
     * Test of updateQuantity method, of class ShoppingCart.
     */
    @Test // not done
    public void testUpdateQuantity() {
        System.out.println("updateQuantity");
        int x = 0;
        Item item = null;
        ShoppingCart instance = null;
        instance.updateQuantity(x, item);
       }
    /**
     * Test of getItem method, of class ShoppingCart.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        String itemName = "";
        String condition = "";
        ShoppingCart instance = null;
        Item expResult = null;
        Item result = instance.getItem(itemName, condition);
        assertEquals(expResult, result);}
    /**
     * Test of TotalShoppingNumber method, of class ShoppingCart.
     */
    @Test //done
    public void testTotalShoppingNumber() {
        System.out.println("TotalShoppingNumber");
        ShoppingCart instance = new ShoppingCart(11, 50);
        Item pen = new Item("pen", "old", 1, 1.1 );  // adding new item to the array
        instance.addtoShoppingCart(pen);
        int expResult = 1;
        int result = instance.TotalShoppingNumber();
        assertEquals(expResult, result);
       }

    /**
     * White box testing:
     */
    @Test //done
    public void testViewCartDetails() {
        System.out.println("viewCartDetails");
        ShoppingCart instance = new ShoppingCart(11, 50.5);
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
        ShoppingCart instance = new ShoppingCart(11, 50.5);
        String expResult = "Numbers of Items 0 Subtotal 0.0";
        String result = instance.toString();
        assertEquals(expResult, result);
       }
    
}