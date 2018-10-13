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
        
    }
    
    public ProcessObject objectsToProcess[];
    public long start;
    public long end;
    
    public Demonstration(){
        //Create all the ProcessObjects
        for(int i = 0; i < 50; ++i){
            objectsToProcess[i] = new ProcessObject();
        }
        
    }
    
    
}
