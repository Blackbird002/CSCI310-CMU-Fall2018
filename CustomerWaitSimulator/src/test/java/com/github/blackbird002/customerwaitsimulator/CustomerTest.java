/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.customerwaitsimulator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author riads
 */
public class CustomerTest {
    
    public CustomerTest() {
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

    @Test
    public void testSomeMethod() {
        
    }

    /**
     * Test of generateProcTime method, of class Customer.
     */
    @Test
    public void testGenerateProcTime() {
        boolean test = false;
        System.out.println("generateProcTime");
        Customer instance = new Customer();
        int upper = 300;
        int lower = 60;
        int result = instance.generateProcTime();
        
        //Checks if less than upper boundary 
        if(result < upper)
            test = true;
        else
            test = false;
        
        //Checks if greater or equal to lower boundary
        if(result >= lower)
            test = true;
        else
            test = false;
        
        assertTrue(test);
    }
    
    /**
     * Test of generateProcTime method, of class Customer.
     */
    @Test
    public void testGenerateProcTimeTest2() {
        boolean test = false;
        System.out.println("generateProcTime");
        Customer instance = new Customer("Jimmy");
        int upper = 300;
        int lower = 60;
        
        //Checks if less than upper boundary 
        if(instance.getProcTime() < upper)
            test = true;
        else
            test = false;
        
        //Checks if greater or equal to lower boundary
        if(instance.getProcTime() >= lower)
            test = true;
        else
            test = false;
        
        assertTrue(test);
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcTime method, of class Customer.
     */
    @Test
    public void testGetProcTime() {
        System.out.println("getProcTime");
        Customer instance = new Customer();
        int expResult = 0;
        int result = instance.getProcTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getwaitedTime method, of class Customer.
     */
    @Test
    public void testGetwaitedTime() {
        System.out.println("getwaitedTime");
        Customer instance = new Customer();
        int expResult = 0;
        int result = instance.getwaitedTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrementProcTime method, of class Customer.
     */
    @Test
    public void testDecrementProcTime() {
        System.out.println("decrementProcTime");
        Customer instance = new Customer("Joe");
        int prevProcTime = instance.getProcTime();
        instance.decrementProcTime();
        boolean test = (instance.getProcTime() < prevProcTime);
        assertTrue(test);   
    }

    /**
     * Test of getOriginalProc method, of class Customer.
     */
    @Test
    public void testGetOriginalProc() {
        System.out.println("getOriginalProc");
        Customer instance = new Customer();
        int expResult = instance.getProcTime();
        int result = instance.getOriginalProc();
        assertEquals(expResult, result);
    }

    /**
     * Test of addWait method, of class Customer.
     */
    @Test
    public void testAddWait() {
        boolean test = false;
        System.out.println("addWait");
        Customer instance = new Customer();
        int prevWait = instance.getwaitedTime();
        instance.addWait();

        if(instance.getwaitedTime() > prevWait)
            test = true;
        else
            test = false;

        assertTrue(test);
    }   
}
