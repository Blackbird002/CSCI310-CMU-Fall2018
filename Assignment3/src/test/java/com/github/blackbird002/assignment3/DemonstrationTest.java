/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.assignment3;

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
public class DemonstrationTest {
    
    public DemonstrationTest() {
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
     * Test of main method, of class Demonstration.
     * Not going to test this method 
     */
    @Test
    public void testMain(){}

    /**
     * Test of doDemonstration method, of class Demonstration.
     */
    @Test
    public void testDoDemonstration() {
        boolean test = true;
        System.out.println("doDemonstration");
        Demonstration instance = new Demonstration();
        instance.doDemonstration();
        
        //Tests if all the threads are not alive
        if(instance.thread1.thrd.isAlive() && instance.thread2.thrd.isAlive()
           && instance.thread3.thrd.isAlive() && instance.thread4.thrd.isAlive())
            test = false;
        
        assertTrue(test);
        
        int numPresent = 0;
        int expNumPresent = 4;
        for(String line : instance.objectsToProcess[0].visitedlist){
               //Tests if each thread added a string to the visitedlist
               assertTrue(line.startsWith("Thread Child"));  
               numPresent++;
        }
        
        assertEquals(expNumPresent,numPresent);  
        numPresent = 0;
        
        for(String line : instance.objectsToProcess[1].visitedlist){
               //Tests if each thread added a string to the visitedlist
               assertTrue(line.startsWith("Thread Child"));  
               numPresent++;
        }
        
        assertEquals(expNumPresent,numPresent);  
        numPresent = 0;
        
        for(String line : instance.objectsToProcess[2].visitedlist){
               //Tests if each thread added a string to the visitedlist
               assertTrue(line.startsWith("Thread Child"));  
               numPresent++;
        }
        
        assertEquals(expNumPresent,numPresent);  
        numPresent = 0;
        
        for(String line : instance.objectsToProcess[3].visitedlist){
               //Tests if each thread added a string to the visitedlist
               assertTrue(line.startsWith("Thread Child"));  
               numPresent++;
        }
        
        assertEquals(expNumPresent,numPresent);  
    }    
}
