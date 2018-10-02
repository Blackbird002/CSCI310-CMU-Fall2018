/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.customerwaitsimulator;
import java.util.Random;

/**
 *
 * @author riads
 */
public final class Customer {
    private String name;
    private int processingTime;
    private int waitedTime;
    
    //Stores the orginal proc time for final wait calculation
    private int originalProcTime;
    
    //Constructor
    public Customer(String inputName, int InputprocTime){
        name = inputName;
        processingTime = InputprocTime;
        originalProcTime = processingTime;
        waitedTime = 0;
    }
    
    public Customer(String inputName){
        name = inputName;
        processingTime = generateProcTime();
        originalProcTime = processingTime;
        waitedTime = 0;
    }
    
    //Defualt constructor 
    public Customer(){
        name = "John Doe";
        processingTime = 0;
        originalProcTime = processingTime;
        waitedTime = 0;
    }
    
    //Accessors 
    public String getName(){return name;}
    public int getProcTime(){return processingTime;}
    public int getwaitedTime(){return waitedTime;}
    public int getOriginalProc(){return originalProcTime;}

    public void decrementProcTime(){
        processingTime--;
    }

    public void addWait(){
        waitedTime++;
    }
    
    
    public int generateProcTime(){
        //Inclusive
        int min = 60;
        
        //Exclusive
        int max = 300;
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;   
    }
}
