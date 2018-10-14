/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.assignment3;

import java.util.LinkedList;
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
public class ProcessObjectTest {
    
    public ProcessObjectTest() {
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
     * Test of getId method, of class ProcessObject.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ProcessObject instance = new ProcessObject(25);
        int expResult = 25;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of printVisitedList method, of class ProcessObject.
     */
    @Test
    public void testPrintVisitedList() {
        Demonstration demo = new Demonstration();
        demo.doDemonstration();
        
        int numPresent = 0;
        int expNumPresent = 4;
        for(String line : demo.objectsToProcess[0].visitedlist){
               //Tests if each thread added a string to the visitedlist
               assertTrue(line.startsWith("Thread Child"));  
               numPresent++;
        }
        //Tests if 4 threads visited the object
        assertEquals(expNumPresent,numPresent);
           
    }
    
}
