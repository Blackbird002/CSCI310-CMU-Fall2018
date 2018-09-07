/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.counting_stars;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author riads
 */
public class CountingStars {
    public static void main(String args[]) throws Exception{
        CountingStars countingStars = new CountingStars();
        countingStars.go();
    }
    
    void go() throws Exception{
        in = new Scanner(System.in);
        out = System.out;
        
        for(;;){
            if(haveTestCase()){
                readTestCase();
                solve();
                writeTestCase();
            }
            else{
                break;
            }
        }

    }  
    

    //Global variables
    Scanner in;
    PrintStream out;
    
    
    int rows;
    int cols;
    int stars;
    boolean[][] picture;

    private void readTestCase() {
        rows = in.nextInt();
        cols = in.nextInt();
        picture = new boolean[rows][cols];
        for(int row = 0; row < rows; ++row){
            String line = in.nextLine();
            picture[row] = parseRow(line);
        }
    }

    public void solve() {
        
        stars = 0;
        for(int row = 0; row < rows; ++row){
            for(int col = 0; col < cols; ++col){
                if(picture[row][col]){
                    ++stars;
                    erase(row,col);
                }

            }
        }
    }

    private void writeTestCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean haveTestCase() {
        return in.hasNextInt();
    }

    private void erase(int row, int col) {
        picture[row][col] = false;

        if(row+1 < rows && picture[row+1][col]){erase(row+1,col);}
        if(row-1 >= 0 && picture[row-1][col]){erase(row-1,col);}
        if(col+1 < cols && picture[row][col+1]){erase(row,col+1);}
        if(col-1 >= 0 && picture[row][col-1]){erase(row,col-1);}
        

        
    }

    boolean[] parseRow(String string) {
        boolean [] data = new boolean[string.length()];
        for(int col = 0; col < string.length(); ++col){
            data[col] = string.charAt(col) == '-';
        }
        
        return data;
    }
    
}
