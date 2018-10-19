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
    
    public ProcessThread thread1;
    public ProcessThread thread2;
    public ProcessThread thread3;
    public ProcessThread thread4;
     public ProcessObject[] objectsToProcess;
    
    public static void main(String args[]){
       System.out.println("==================================================");
       Demonstration firstDemo = new Demonstration();
       
       firstDemo.doDemonstration();
        
    }
    
    public Demonstration(){
        //Create 4 threads
        thread1 = new ProcessThread("Child#1", this);
        thread2 = new ProcessThread("Child#2", this);
        thread3 = new ProcessThread("Child#3", this);
        thread4 = new ProcessThread("Child#4", this);
        
        //Create the array of process objects
        objectsToProcess = new ProcessObject[50]; 
        
        //Create all the ProcessObjects
        for(int i = 0; i < 50; ++i){
            objectsToProcess[i] = new ProcessObject(i);
        }
        
    }
    
    //Method that does the action
    public void doDemonstration(){      
        
        //Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        try{
            thread1.thrd.join();
            thread2.thrd.join();
            thread3.thrd.join();
            thread4.thrd.join();
        }catch(InterruptedException exc){
            System.out.println("A was thread interrupted.");
        }
        
        System.out.println("All threads joined! Only main thread is left.");
        System.out.println("Printing the ProcessObj lists: ");
        
        int num = 1;
        for (ProcessObject obj : objectsToProcess) {
           System.out.println("Process Object: " + num);
           num++;
           obj.printVisitedList();
           System.out.println();
        }
    }   
}
