/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.assignment3;

/**
 *
 * @author riads
 */
public class Demonstration {
    
    public static void main(String args[]){
       Demonstration firstDemo = new Demonstration();
       
       firstDemo.doDemonstration();
        
    }
    
    public ProcessObject[] objectsToProcess;
    public long start;
    public long end;
    
    public Demonstration(){
        objectsToProcess = new ProcessObject[50]; 
        
        //Create all the ProcessObjects
        for(int i = 0; i < 50; ++i){
            objectsToProcess[i] = new ProcessObject(i);
            System.out.println("Created ProcessObject: " + objectsToProcess[i].getId());
        }
        
    }
    
    public void doDemonstration(){
        ProcessThread thread1 = new ProcessThread("Child#1", this);
        ProcessThread thread2 = new ProcessThread("Child#2", this);
        ProcessThread thread3 = new ProcessThread("Child#3", this);
        ProcessThread thread4 = new ProcessThread("Child#4", this);
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        
    }
    
    
}
