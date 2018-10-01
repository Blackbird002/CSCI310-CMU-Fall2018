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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    
}
