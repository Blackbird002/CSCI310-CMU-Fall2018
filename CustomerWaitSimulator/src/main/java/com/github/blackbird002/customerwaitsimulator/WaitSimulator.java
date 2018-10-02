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

    public static void main(String args[]){
        WaitSimulator sim = new WaitSimulator();

        System.out.println("Running the simulation...");
        sim.runSimulation();

        
        for(int i = 0; i < sim.checkedOutCustomers.size(); ++i)
            System.out.println(sim.checkedOutCustomers.get(i).getName() + " waited: " + sim.checkedOutCustomers.get(i).getwaitedTime()
             + " Processing Time: " + sim.checkedOutCustomers.get(i).getOriginalProc());
    }
    
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
            checkOutCustomers.add(new Customer("Customer " + Integer.toString(i)));
            
    }

    public void decrementAllTopCustomers(){
        //Decrement the processing time for each person being serviced at the top of the queue
        if(!Reg1.isEmpty())
            Reg1.peek().decrementProcTime();
        
        if(!Reg2.isEmpty())
            Reg2.peek().decrementProcTime();

        if(!Reg3.isEmpty())
            Reg3.peek().decrementProcTime();

    }

    public void checkIfDone(){
        if(!Reg1.isEmpty())
            if(Reg1.peek().getProcTime() <= 0){
                Customer temp = Reg1.remove();
                checkedOutCustomers.add(temp);
            }
                
        
        if(!Reg2.isEmpty())
            if(Reg2.peek().getProcTime() <= 0){
                Customer temp = Reg2.remove();
                checkedOutCustomers.add(temp);
            }
                
            
        if(!Reg3.isEmpty())
            if(Reg3.peek().getProcTime() <= 0){
                Customer temp = Reg3.remove();
                checkedOutCustomers.add(temp);  
            }
    }

    public void addCustomersToQueues(){
        while((Reg1.size() < 5 || Reg2.size() < 5 || Reg2.size() < 5) && !checkOutCustomers.isEmpty())
            if(Reg1.size() < 5){
                Reg1.add(checkOutCustomers.remove());
            }
            else if(Reg2.size() < 5){
                Reg2.add(checkOutCustomers.remove());
            }
            else if(Reg3.size() < 5){
                Reg3.add(checkOutCustomers.remove());
            }
    }

    public void addWaitingTime(){
        //Adds 1 to wait time of customers in checkoutCustomers
        if(!checkOutCustomers.isEmpty())
            for(Customer cust : checkOutCustomers)
                cust.addWait();

        if(!Reg1.isEmpty())
            for(Customer cust : Reg1)
                cust.addWait();

        if(!Reg2.isEmpty())
            for(Customer cust : Reg2)
                cust.addWait();

        if(!Reg1.isEmpty())
            for(Customer cust : Reg1)
                cust.addWait();   
    }
    
    
    public void runSimulation(){
        //While there are still customers in line or in the queues
        while(checkOutCustomers.isEmpty() == false || Reg1.isEmpty() == false || Reg2.isEmpty() == false || Reg3.isEmpty() == false){
            
            //Adds each customer to a queue (5 max per queue)
            addCustomersToQueues();
            //If queues are all full, customers wait in checkOutCustomers

            //Decrement the processing time for each person being serviced at the top of the queue
            decrementAllTopCustomers();

            //If a customer is done being processed, they are poped off the queue and added to processed list
            checkIfDone();

            //Add 1 to waitedTime to all customers still waiting in checkOutCustomers queue
            addWaitingTime();
            
        }
    }
        
    
    
    
    
}

