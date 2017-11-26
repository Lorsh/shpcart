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
 * @author LFXIII
 */
public class ItemTest {
    
    Item testItem =  new Item("testName", "testCond", 5, 100);
    
    public ItemTest() {
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
     * Test of equals method, of class Item.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Item("testName", "testCond", 1, 200);
        Item instance = testItem;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype."); 
    }

    /**
     * Test of toString method, of class Item.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Item instance = testItem;
        String expResult = "Name:\t\t"+"testName"+"\n" + "Price:\t\t"+"100"+"\n" + "Condition: \t\t"+"testCond"+"\n" + "Product ID:\t\t"+"5"+"\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype. ");
    }
    
}
