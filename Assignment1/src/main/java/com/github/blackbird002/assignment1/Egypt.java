/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.assignment1;
import java.util.Scanner;

/**
 *
 * @author riads
 */
public class Egypt {
    public static void main(String args[]){

        String inputStr = "";
        int[] threeInts;
        boolean result;

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            result = false;
            inputStr = sc.nextLine();
            threeInts = splitString(inputStr);

            //Exits the program is 0 0 0 is entered
            if(threeInts[0] == 0 || threeInts[1] == 0 || threeInts[2] == 0)
                break;
            
            //EgyptSolver solver = new EgyptSolver(threeInts);

            //result = solver.isRight();

            if(result == true)
                System.out.println("right");
            else
                System.out.println("wrong");
        }                        
    }
    
    public static int[] splitString(String inputStr){
        String[] threeNums = {"0","0","0"};
        int[] threeInts = {0,0,0}; 

        threeNums = inputStr.split(" ");

        for(int i = 0; i <= 2; i++){
            //Type cast the string to an int
            threeInts[i] = Integer.valueOf(threeNums[i]);
        }
        return threeInts;     
    }
}

