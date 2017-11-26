/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.FileNotFoundException;
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
    


  
    /**
     * Test of update method, of class Catalog.
     */
    @Test
    public void testUpdate()  {
        System.out.println("update");
        Catalog instance;
        instance = Catalog.getInstance();
        instance.clear();
        int itemID = 3;
        Item item3 = new Item(itemID);
        instance.addItemToCatalog(item3);  
        instance.update();
        instance = null;  // hopefully this destroys the only object available
        instance = Catalog.getInstance(); // here we are creating a new object, with all the items being picked up from the file.
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(true,instance.checkItemExist(itemID));
        
    }

    /**
     * Test of removeItemFromCatalog method, of class Catalog.
     */
    @Test
    public void testRemoveItemFromCatalog() throws Exception {
        System.out.println("removeItemFromCatalog");
        int productID = 0;
        Item item = new Item(productID);
        Catalog instance = Catalog.getInstance();
        instance.clear();
        instance.addItemToCatalog(item);
        if (instance.checkItemExist(productID)) {
            instance.removeItemFromCatalog(productID);
            assertEquals(false,instance.checkItemExist(productID));
        }
        else {
            fail("Item was not added properly");
        }
    }

    /**
     * Test of checkItemExist method, of class Catalog.
     */
    @Test
    public void testCheckItemExist() {
        System.out.println("checkItemExist");
        int itemID = 0;
        Item item = new Item(itemID);
        Catalog instance = Catalog.getInstance();
        instance.clear();
        instance.addItemToCatalog(item);
        boolean result = instance.checkItemExist(itemID);
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getItem method, of class Catalog.
     */
    
    
    
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        int itmID = 0;
        Item item = new Item(itmID);
        Catalog instance = Catalog.getInstance();
        instance.clear();
        instance.addItemToCatalog(item);
        Item result = instance.getItem(itmID);
        assertEquals(true, result.equals(item));
        
    }

    /**
     * Test of addItemToCatalog method, of class Catalog.
     */
    @Test
    public void testAddItemToCatalog() throws Exception {
        System.out.println("addItemToCatalog");
        int itemID = 1;
        Item item = new Item(itemID);
        Catalog instance = Catalog.getInstance();
        instance.addItemToCatalog(item);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(true,instance.checkItemExist(itemID));
        
    }

    /**
     * Test of repOK method, of class Catalog.
     */
    @Test
    public void testRepOK() {
        System.out.println("repOK");
        Catalog instance = Catalog.getInstance();
        instance.clear();
        Item item1 = new Item(0);
        instance.addItemToCatalog(item1);
        Item item2 = new Item(1);
        instance.addItemToCatalog(item2);
        Item item3 = new Item(2);
        instance.addItemToCatalog(item3);
        Item item4 = new Item(3);
        instance.addItemToCatalog(item4);
        boolean result = instance.repOK();
        assertEquals(true, result);
    }
    
}
