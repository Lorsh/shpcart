/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

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
        ShoppingCart instance = null;
        int expResult = 0;
        int result = instance.getshoppingID();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of addtoShoppingCart method, of class ShoppingCart.
     */
    @Test
    public void testAddtoShoppingCart() {
        System.out.println("addtoShoppingCart");
        Item item = null;
        ShoppingCart instance = null;
        instance.addtoShoppingCart(item);
       
    }

    /**
     * Test of getsubtotal method, of class ShoppingCart.
     */
    @Test
    public void testGetsubtotal() {
        System.out.println("getsubtotal");
        ShoppingCart instance = null;
        double expResult = 0.0;
        double result = instance.getsubtotal();
        assertEquals(expResult, result, 0.0);
       }

    /**
     * Test of checkOut method, of class ShoppingCart.
     */
    @Test
    public void testCheckOut() {
        System.out.println("checkOut");
        ShoppingCart instance = null;
        instance.checkOut();
       }

    /**
     * Test of removeFromShoppingCart method, of class ShoppingCart.
     */
    @Test
    public void testRemoveFromShoppingCart() {
        System.out.println("removeFromShoppingCart");
        Item item = null;
        ShoppingCart instance = null;
        instance.removeFromShoppingCart(item);
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
     * Test of viewCartDetails method, of class ShoppingCart.
     */
    @Test //done
    public void testViewCartDetails() {
        System.out.println("viewCartDetails");
        ShoppingCart instance = new ShoppingCart(11, 50.5);
        String expResult = "Shopping ID is"  +instance.getshoppingID()+ "Number of Items" +instance.TotalShoppingNumber()+ "Subtotal" +instance.getsubtotal();
        String result = instance.viewCartDetails();
        assertEquals(expResult, result);
       }

    /**
     * Test of calculateSub method, of class ShoppingCart.
     */
    @Test //done
    public void testCalculateSub() {
        System.out.println("calculateSub");
        ShoppingCart instance = new ShoppingCart(11, 50.5);
        double expResult = 57.065;
        double epsilon = 0.5;
        double result = instance.calculateSub();
        assertEquals(expResult, result, epsilon);
       }

    /**
     * Test of toString method, of class ShoppingCart.
     */
    @Test //not done
    public void testToString() {
        System.out.println("toString");
        ShoppingCart instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
       }
    
}
