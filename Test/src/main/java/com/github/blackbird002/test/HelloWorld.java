package com.github.blackbird002.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//HAHAHA

/**
 *
 * @author riads
 */
public class HelloWorld {

    public static void main(String args[]) throws Exception {
        //Creates a new instance of HelloWorld type
        HelloWorld helloWorld = new HelloWorld();

        //Invoke some method
        helloWorld.sayMessage();

        int x = 3;
    }

    private String message = "";

    public void setMessage(String _message) {
        if (_message != null) {
            message = _message;
        } else {
            throw new UnsupportedOperationException("Message cannot be null!");
        }
    }
    
    

    private void sayMessage() {
        System.out.println(getMessage());
    }

    public String getMessage() {
        return message;
    }
}
