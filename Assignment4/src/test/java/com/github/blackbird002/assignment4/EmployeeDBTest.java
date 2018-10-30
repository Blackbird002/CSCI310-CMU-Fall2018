/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.assignment4;

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
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        EmployeeDB.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewDatabase method, of class EmployeeDB.
     */
    @Test
    public void testCreateNewDatabase() {
        System.out.println("createNewDatabase");
        EmployeeDB instance = new EmployeeDB();
        instance.createNewDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewTable method, of class EmployeeDB.
     */
    @Test
    public void testCreateNewTable() {
        System.out.println("createNewTable");
        EmployeeDB instance = new EmployeeDB();
        instance.createNewTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readDatabase method, of class EmployeeDB.
     */
    @Test
    public void testReadDatabase() {
        System.out.println("readDatabase");
        EmployeeDB instance = new EmployeeDB();
        instance.readDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertEmployee method, of class EmployeeDB.
     */
    @Test
    public void testInsertEmployee() {
        System.out.println("insertEmployee");
        int id = 0;
        String name = "";
        int age = 0;
        float salary = 0.0F;
        String position = "";
        EmployeeDB instance = new EmployeeDB();
        instance.insertEmployee(id, name, age, salary, position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
