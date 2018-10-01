/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.customerwaitsimulator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author riads
 * Assignment #2 for CSCI 310 - Java
 * Program simulates a line at a grocery store with 3 cash registers implemented
 * as a queue data structure. 
 * This program will use the Java collections library 
 */
public class WaitSimulator {
    
    //The check out register sections
    public Queue<Customer> Reg1;
    public Queue<Customer> Reg2;
    public Queue<Customer> Reg3;
    public LinkedList<Customer> checkedOutCustomers;
    
    //Customers to be checked out
    public Queue<Customer> checkOutCustomers;
    
    //Default Constructor
    public WaitSimulator(){
        Reg1 = new LinkedList<>();
        Reg2 = new LinkedList<>();
        Reg3 = new LinkedList<>();
        
        checkOutCustomers = new LinkedList<>();
        checkedOutCustomers = new LinkedList<>();
        
        for(int i = 0; i <= 20; i++)
            checkOutCustomers.add(new Customer("Generic"));
    }
    
    
    public void runSimulation(){
        
    }
        
    
    
    
    
}

