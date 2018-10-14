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
public class ProcessThreadTest {
    
    public ProcessThreadTest() {
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
     * Test of addProcNote method, of class ProcessThread.
     */
    @Test
    public void testAddProcNote() {
        System.out.println("addProcNote");
        Demonstration demo = new Demonstration();
        
        //Creates the thread, does not run it
        ProcessThread instance = new ProcessThread("Child#1", demo);
        int index = 0;
        instance.addProcNote(index);
        
        String expected = "Thread Child#1 was here!";
        assertEquals(expected, demo.objectsToProcess[0].visitedlist.peekFirst());
        
    }

    /**
     * Test of start method, of class ProcessThread.
     * I just a test to see if a thread is running.
     */
    @Test
    public void testStart() {
        System.out.println("addProcNote");
        boolean test = false;
        Demonstration demo = new Demonstration();
        
        ProcessThread instance = new ProcessThread("Child#1", demo);
        
        instance.start();
        
        if(instance.thrd.isAlive()){
            test = true;
        }
        assertTrue(test);
        
        //Wait for the thread to finish
        try{
            instance.thrd.join();
        }catch(InterruptedException exc){
            System.out.println("A was thread interrupted.");
        }
        
    }

    /**
     * Test of run method, of class ProcessThread.
     */
    @Test
    public void testRun() {
        System.out.println("addProcNote");
        boolean test = false;
        Demonstration demo = new Demonstration();
        
        ProcessThread instance = new ProcessThread("Child#1", demo);
        
        instance.start();
        
        if(instance.thrd.isAlive()){
            test = true;
        }
        assertTrue(test);
        
        //Wait for the thread to finish
        try{
            instance.thrd.join();
        }catch(InterruptedException exc){
            System.out.println("A was thread interrupted.");
        }
    }
    
}
