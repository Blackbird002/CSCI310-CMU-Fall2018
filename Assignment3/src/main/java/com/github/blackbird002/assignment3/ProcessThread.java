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
public class ProcessThread implements Runnable {
    
    //Create the general thread
    Thread thrd;
    Demonstration demo;
    
    long start;
    long end;
    
    //Construct the new thread
    ProcessThread(String name, Demonstration _demo){
        thrd = new Thread(this, name);
        demo = _demo;
    }
    
    public void addProcNote(int index){
        String inputStr;
        inputStr = "Thread " + thrd.getName() + " was here!";
        
        //Synchronize usage of the ProcessObjects in the array
        synchronized(demo.objectsToProcess[index]){
            demo.objectsToProcess[index].visitedlist.add(inputStr);
        }
        
        //I let the treads sleep to introduce some variation
        try{
            Thread.sleep(50);
        }
        catch (InterruptedException exc){
            System.out.println("Thread interrupted.");
        }
    }
    
    public void start(){
        thrd.start();
        start = System.currentTimeMillis();
    }
    
    
    
    @Override
    public void run() {
        for(int i = 0; i < demo.objectsToProcess.length; ++i){
            addProcNote(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Thread " + thrd.getName() + " finished with a time of "
                + (end-start));
    }
    
}
