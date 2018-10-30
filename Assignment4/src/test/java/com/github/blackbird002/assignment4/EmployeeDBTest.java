/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.assignment4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author riads
 */
public class EmployeeDBTest {
    
    public EmployeeDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class EmployeeDB.
     * No need to test main...
     */
    @Test
    public void testMain() {}

    /**
     * Test of readDatabase method, of class EmployeeDB.
     */
    @Test
    public void testReadDatabase() {
        boolean test = false;
        //Prints all the database records to the terminal
        System.out.println("readDatabase");
        EmployeeDB instance = new EmployeeDB();
        instance.readDatabase();
        
        //The employee ID that we will check to see if in table
        int id = 0;
        float salary = 38000.0f;
        
        String sql = "SELECT * FROM EMPLOYEES where ID = 0;";
        try (Connection con = instance.connect();
            Statement stmt = con.createStatement()) {
            
            //Execute the query and store in ResultSet
            ResultSet resultsFromQuery = stmt.executeQuery(sql);
            
            int tid = resultsFromQuery.getInt("ID");
            float tsalary = resultsFromQuery.getFloat("SALARY");
            
            while(resultsFromQuery.next()){
                System.out.println();

                //Get the information from the record
                tid = resultsFromQuery.getInt("ID");
               
                if(tid == id && tsalary == salary)
                    test = true;
            }
            
            //Close everything!
            resultsFromQuery.close();
            stmt.close();
            con.close();

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
        assertTrue(test);       
    }

    @Test
    public void testReadDatabaseCase2() {
        boolean test = false;
        //Prints all the database records to the terminal
        System.out.println("readDatabase");
        EmployeeDB instance = new EmployeeDB();
        instance.readDatabase();
        
        //The employee ID that we will check to see if in table
        int id = 3;
        float salary = 40000.0f;
        
        String sql = "SELECT * FROM EMPLOYEES where ID = 3;";
        try (Connection con = instance.connect();
            Statement stmt = con.createStatement()) {
            
            //Execute the query and store in ResultSet
            ResultSet resultsFromQuery = stmt.executeQuery(sql);
            
            int tid = resultsFromQuery.getInt("ID");
            float tsalary = resultsFromQuery.getFloat("SALARY");
            
            while(resultsFromQuery.next()){
                System.out.println();

                //Get the information from the record
                tid = resultsFromQuery.getInt("ID");
               
                if(tid == id && tsalary == salary)
                    test = true;
            }
            
            //Close everything!
            resultsFromQuery.close();
            stmt.close();
            con.close();

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
        assertTrue(test);       
    }


    /**
     * Test of insertEmployee method, of class EmployeeDB.
     */
    @Test
    public void testInsertEmployee() {
        boolean test = false;
        System.out.println("insertEmployee");
        int id = 12;
        String name = "John Doe";
        int age = 23;
        float salary = 18000;
        String position = "Intern";
        EmployeeDB instance = new EmployeeDB();
        
        instance.insertEmployee(id, name, age, salary, position);
        
        String sql = "SELECT * FROM EMPLOYEES where ID = 12;";
        try (Connection con = instance.connect();
            Statement stmt = con.createStatement()) {
            
            //Execute the query and store in ResultSet
            ResultSet resultsFromQuery = stmt.executeQuery(sql);
            
            int tid = 0;

            while(resultsFromQuery.next()){
                System.out.println();

                //Get the information from the record
                tid = resultsFromQuery.getInt("ID");
            }
            
            if(id == tid)
                test = true;
            else
                test = false;
            
            //Close everything!
            resultsFromQuery.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Delete the added Employee so test can run again
        instance.deleteEmployee(12);
        assertTrue(test);
    }

    /**
     * Test of deleteEmployee method, of class EmployeeDB.
     */
    @Test
    public void testDeleteEmployee() {
        boolean test = true;
        System.out.println("deleteEmployee");
        EmployeeDB instance = new EmployeeDB();

        int id = 11;
        String name = "Sean";
        int age = 21;
        float salary = 100000;
        String position = "Programmer";

        //We add the employee
        instance.insertEmployee(id, name, age, salary, position);

        //Then we remove the employee with id
        instance.deleteEmployee(id);

        //Now we check if there emplyee is not in the dataase
        String sql = "SELECT * FROM EMPLOYEES;";
        try (Connection con = instance.connect();
            Statement stmt = con.createStatement()) {
            
            //Execute the query and store in ResultSet
            ResultSet resultsFromQuery = stmt.executeQuery(sql);

            int tid = 0;

            while(resultsFromQuery.next()){
                System.out.println();

                //Get the information from the record
                tid = resultsFromQuery.getInt("ID");    

                //If we see the record again.. we fail this test
                if(tid == id)
                    test = false;
            }
            
            //Close everything!
            resultsFromQuery.close();
            stmt.close();
            con.close();

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("No more records!");

        assertTrue(test);
    }
    
    @Test
    public void testDeleteEmployeeCase2() {
        boolean test = true;
        System.out.println("deleteEmployee");
        EmployeeDB instance = new EmployeeDB();

        int id = 30;
        String name = "Alex";
        int age = 27;
        float salary = 100000;
        String position = "Programmer";

        //We add the employee
        instance.insertEmployee(id, name, age, salary, position);

        //Then we remove the employee with id
        instance.deleteEmployee(id);

        //Now we check if there emplyee is not in the dataase
        String sql = "SELECT * FROM EMPLOYEES;";
        try (Connection con = instance.connect();
            Statement stmt = con.createStatement()) {
            
            //Execute the query and store in ResultSet
            ResultSet resultsFromQuery = stmt.executeQuery(sql);

            int tid = 0;

            while(resultsFromQuery.next()){
                System.out.println();

                //Get the information from the record
                tid = resultsFromQuery.getInt("ID");    

                //If we see the record again.. we fail this test
                if(tid == id)
                    test = false;
            }
            
            //Close everything!
            resultsFromQuery.close();
            stmt.close();
            con.close();

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("No more records!");

        assertTrue(test);
    }

    /**
     * Test of updateEmployee method, of class EmployeeDB.
     */
    @Test
    public void testUpdateEmployee() {
        boolean test = false;

        System.out.println("updateEmployee");
        int id = 20;
        String name = "Spock";
        int age = 150;
        float salary = 90000.0f;
        String position = "Chief Scientist";

        EmployeeDB instance = new EmployeeDB();

        //We add Spock to the database
        instance.insertEmployee(id, name, age, salary, position);

        //We increased Spock's salary
        instance.updateEmployee(id, name, age, 120000.0f, position);

        String sql = "SELECT * FROM EMPLOYEES where ID = 20;";
        try (Connection con = instance.connect();
            Statement stmt = con.createStatement()) {
            
            //Execute the query and store in ResultSet
            ResultSet resultsFromQuery = stmt.executeQuery(sql);
            
            int tid = 0;
            float tsalary = 0;

            //Get the information from the record
            tid = resultsFromQuery.getInt("ID");
            tsalary = resultsFromQuery.getFloat("SALARY");
            
            System.out.println("tsalary is: " + tsalary);
            
            
            //Chekcs if the salary was updated
            if(id == tid && tsalary == 120000.0f)
                test = true;
            else
                test = false;
            
            //Close everything!
            resultsFromQuery.close();
            stmt.close();
            con.close();

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
        //Delete Spock employee so we can test again
        instance.deleteEmployee(id);

        assertTrue(test);
    }

    /**
     * Test of connect method, of class EmployeeDB.
     * We will just test if the connection is not null
     */
    @Test
    public void testConnect() {
        boolean test = false;
        System.out.println("connect");
        EmployeeDB instance = new EmployeeDB();

        try (Connection con = instance.connect();
            Statement stmt = con.createStatement()) {
            
            if(con.isValid(1) && con != null)
                test = true;
            else
                test = false;

            //Close everything!
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
        assertTrue(test);    
        
    }
}
