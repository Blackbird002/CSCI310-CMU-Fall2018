/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.assignment1;

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
public class EgyptTest {
    
    public EgyptTest() {
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
     * Test of main method, of class Egypt.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Egypt.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of splitString method, of class Egypt.
     */
    @Test
    public void testSplitString() {
        System.out.println("splitString");
        String inputStr = "8 6 10";
        int[] expResult = {8, 6, 10};
        int[] result = Egypt.splitString(inputStr);
        assertArrayEquals(expResult, result);
    }
    
}
