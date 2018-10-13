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
    
    //Construct the new thread
    ProcessThread(String name, ProcessObject obj){
        thrd = new Thread(this, name);
    }
    
    public void addProcNote(int index){
        String inputStr;
        inputStr = "Thread: " + thrd.getName() + " was here!";
    }
    
    @Override
    public void run() {
    }
    
}
