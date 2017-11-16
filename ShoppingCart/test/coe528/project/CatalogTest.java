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
 * @author Emil
 */
public class CatalogTest {
    
    public CatalogTest() {
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
     * Test of getInstance method, of class Catalog.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Catalog expResult = null;
        Catalog result = Catalog.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Catalog.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Catalog instance = null;
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItemFromCatalog method, of class Catalog.
     */
    @Test
    public void testRemoveItemFromCatalog() throws Exception {
        System.out.println("removeItemFromCatalog");
        int productID = 0;
        Catalog instance = null;
        instance.removeItemFromCatalog(productID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkItemExist method, of class Catalog.
     */
    @Test
    public void testCheckItemExist() {
        System.out.println("checkItemExist");
        int itmID = 0;
        Catalog instance = null;
        boolean expResult = false;
        boolean result = instance.checkItemExist(itmID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class Catalog.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        int itmID = 0;
        Catalog instance = null;
        Item expResult = null;
        Item result = instance.getItem(itmID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProfileToCatalog method, of class Catalog.
     */
    @Test
    public void testAddProfileToCatalog() throws Exception {
        System.out.println("addProfileToCatalog");
        Item item = null;
        Catalog instance = null;
        instance.addProfileToCatalog(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
