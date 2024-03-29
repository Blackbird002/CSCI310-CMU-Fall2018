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

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author riads
 */
public class WaitSimulatorTest {
    
    public WaitSimulatorTest() {
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
     * Test of main method, of class WaitSimulator.
     */
    @Test
    public void testMain() {
        
    }

    /**
     * Test of decrementAllTopCustomers method, of class WaitSimulator.
     */
    @Test
    public void testDecrementAllTopCustomers() {
        System.out.println("decrementAllTopCustomers");
        WaitSimulator instance = new WaitSimulator();
        instance.addCustomersToQueues();

        int R1 = instance.Reg1.peek().getProcTime();
        int R2 = instance.Reg2.peek().getProcTime();
        int R3 = instance.Reg3.peek().getProcTime();

        instance.decrementAllTopCustomers();

        boolean test = true;

        if(instance.Reg1.peek().getProcTime() >= R1)
            test = false;

        if(instance.Reg2.peek().getProcTime() >= R2)
            test = false;
        
        if(instance.Reg3.peek().getProcTime() >= R3)
            test = false;

        assertTrue(test);
    }

    /**
     * Test of checkIfDone method, of class WaitSimulator.
     */
    @Test
    public void testCheckIfDone() {
        System.out.println("checkIfDone");
        WaitSimulator instance = new WaitSimulator();
        instance.Reg1.add(new Customer("Ray",0));
        instance.Reg2.add(new Customer("JR", 0));
        instance.Reg3.add(new Customer("Sean", 0));
        instance.checkIfDone();

        boolean test = true;

        if(!instance.Reg1.isEmpty())
            test = false;
        
        if(!instance.Reg2.isEmpty())
            test = false;

        if(!instance.Reg3.isEmpty())
            test = false;

        assertTrue(test);
    }

    /**
     * Test of addCustomersToQueues method, of class WaitSimulator.
     */
    @Test
    public void testAddCustomersToQueues() {
        boolean test = false;
        System.out.println("addCustomersToQueues");
        WaitSimulator instance = new WaitSimulator();
        instance.addCustomersToQueues();
        if(instance.Reg1.peek() != null)
            test = true;
        
        if(instance.Reg2.peek() != null)
            test = true;
        
        if(instance.Reg3.peek() != null)
            test = true;
       
        assertTrue(test);       
    }
    
    //Tests if more than 5 customers get added to the queue
    @Test
    public void testAddCustomersToQueues2() {
        boolean test = false;
        System.out.println("addCustomersToQueues");
        WaitSimulator instance = new WaitSimulator();
        
        //Call this function 10 times
        for(int i = 0; i < 10; ++i)
            instance.addCustomersToQueues();
        
        if(instance.Reg1.size() == 5)
            test = true;
        
        if(instance.Reg2.size() == 5)
            test = true;
        
        if(instance.Reg3.size() == 5)
            test = true;
        assertTrue(test);       
    }

    /**
     * Test of runSimulation method, of class WaitSimulator.
     */
    @Test
    public void testRunSimulation() {
        System.out.println("runSimulation");
        WaitSimulator instance = new WaitSimulator();
        instance.runSimulation();
        
        boolean test = true;

        if(!instance.checkOutCustomers.isEmpty())
            test = false;
        
        if(!instance.Reg1.isEmpty())
            test = false;
        
        if(!instance.Reg2.isEmpty())
             test = false;

        if(!instance.Reg3.isEmpty())
            test = false;

        if(instance.checkedOutCustomers.isEmpty())
            test = false;   
        
        assertTrue(test);
    }

    /**
     * Test of addWaitingTime method, of class WaitSimulator.
     */
    @Test
    public void testAddWaitingTime() {
        System.out.println("addWaitingTime");
        WaitSimulator instance = new WaitSimulator();
        instance.addCustomersToQueues();

        int[] A1 = new int[5]; 
        int[] A2 = new int[5]; 
        int[] A3 = new int[5]; 
        int waiting[] = new int[20];

        instance.addWaitingTime();

        int i = 0;
        for(Customer cust : instance.Reg1){
            A1[i] = cust.getwaitedTime();
            ++i;
        }
            
        i = 0;
        for(Customer cust : instance.Reg2){
            A2[i] = cust.getwaitedTime();
            ++i;
        }
            
        i = 0;
        for(Customer cust : instance.Reg3){
            A3[i] = cust.getwaitedTime();
            ++i;
        }

        i = 0;
        for(Customer cust : instance.checkOutCustomers){
            waiting[i] = cust.getwaitedTime();
            ++i;
        }

        instance.addWaitingTime();
        boolean test = true;

        i = 0;
        for(Customer cust : instance.Reg1){
            if(cust.getwaitedTime() <= A1[i]){
                test = false;
            }
            ++i;
        }

        i = 0;
        for(Customer cust : instance.Reg2){
            if(cust.getwaitedTime() <= A1[i]){
                test = false;
            }
            ++i;
        }

        i = 0;
        for(Customer cust : instance.Reg3){
            if(cust.getwaitedTime() <= A3[i]){
                test = false;
            }
            ++i;
        }

        i = 0;
        for(Customer cust : instance.checkOutCustomers){
            if(cust.getwaitedTime() <= waiting[i]){
                test = false;
            }
            ++i;
        }
        assertTrue(test);
    }
    
}
