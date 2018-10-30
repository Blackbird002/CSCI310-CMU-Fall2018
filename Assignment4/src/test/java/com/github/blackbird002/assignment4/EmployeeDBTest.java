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
        
        try (Connection con = instance.connect();
            Statement stmt = con.createStatement()) {
                    
            if(con != null)
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

    /**
     * Test of insertEmployee method, of class EmployeeDB.
     */
    @Test
    public void testInsertEmployee() {
        boolean test = false;
        System.out.println("insertEmployee");
        int id = 12;
        String name = "JOE";
        int age = 23;
        float salary = 18000;
        String position = "Clerk";
        EmployeeDB instance = new EmployeeDB();
        instance.insertEmployee(id, name, age, salary, position);
        
        String sql = "SELECT * FROM EMPLOYEES where ID = 12;";
        try (Connection con = instance.connect();
            Statement stmt = con.createStatement()) {
            
            //Execute the query and store in ResultSet
            ResultSet resultsFromQuery = stmt.executeQuery(sql);
            
            int tid = resultsFromQuery.getInt("ID");
            String tname = "";
            int tage = 0;
            float tsalary = 0;
            String tposition = "";

            while(resultsFromQuery.next()){
                System.out.println();

                //Get the information from the record
                tid = resultsFromQuery.getInt("ID");
                tname = resultsFromQuery.getString("NAME");
                tage = resultsFromQuery.getInt("AGE");
                tsalary = resultsFromQuery.getFloat("SALARY");
                tposition = resultsFromQuery.getString("POSITION");
            }
            
            System.out.println("id = " + id + " tid = " + tid);
            System.out.println("name = " + name + " tname = " + tname);
            System.out.println("age = " + age + " tage = " + tage);
            System.out.println("salary = " + salary + " tname = " + tsalary);
            System.out.println("position = " + position + " tposition = " + tposition);
            
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
        
        assertTrue(test);
    }

    /**
     * Test of deleteEmployee method, of class EmployeeDB.
     */
    @Test
    public void testDeleteEmployee() {
        System.out.println("deleteEmployee");
        int id = 0;
        EmployeeDB instance = new EmployeeDB();
        instance.deleteEmployee(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployee method, of class EmployeeDB.
     */
    @Test
    public void testUpdateEmployee() {
        System.out.println("updateEmployee");
        int id = 0;
        String name = "";
        int age = 0;
        float salary = 0.0F;
        String position = "";
        EmployeeDB instance = new EmployeeDB();
        instance.updateEmployee(id, name, age, salary, position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
