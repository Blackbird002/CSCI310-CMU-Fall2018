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
public class EgyptSolverTest {
    
    public EgyptSolverTest() {
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
     * Test of isRight method, of class EgyptSolver.
     */
    @Test
    public void testIsRight() {
        System.out.println("isRight");
        EgyptSolver instance = null;
        boolean expResult = false;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bubbleSort method, of class EgyptSolver.
     */
    @Test
    public void testBubbleSortCase1() {
        System.out.println("bubbleSort");
        int[] threeInts = {10,6,8}; 
        int [] expResult = {6,8,10};
        EgyptSolver instance = new EgyptSolver(threeInts);        
        instance.bubbleSort();
        assertArrayEquals(expResult, instance.sides);
    }
    
    @Test
    public void testBubbleSortCase2() {
        System.out.println("bubbleSort");
        int[] threeInts = {8,10,6}; 
        int [] expResult = {6,8,10};
        EgyptSolver instance = new EgyptSolver(threeInts);        
        instance.bubbleSort();
        assertArrayEquals(expResult, instance.sides);
    }
    
}
