/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.assignment3;

import java.util.LinkedList;

/**
 *
 * @author riads
 */
public class ProcessObject {
    
    //A collection of strings indicating what thread added a string
    public LinkedList<String> visitedlist;
    int processObjId;
    
    public int getId(){return processObjId;}
    
    //Default constructor
    public ProcessObject(){
        visitedlist = new LinkedList<String>();
        processObjId = 0;
    }
    
    public ProcessObject(int inID){
        visitedlist = new LinkedList<String>();
        processObjId = inID;
    }
    
    
        
}
