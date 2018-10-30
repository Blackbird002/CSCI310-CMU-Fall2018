package com.github.blackbird002.assignment4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Implementation of C.R.U.D using SQLite database
 * C - Create -> createNewDatase & createNewTable & insertEmplyee
 * R - Read -> readDatabase
 * U - Update ->
 * D - Delete -> deleteEmployee
 * @author riads
 */
public class EmployeeDB {
    
    //Name of the database file:
    public static String DEFAULT_DB = "Employees.db";
    
    //The database URL (jdbc:sqlite:Emplyees.db)
    public static String DEFAULT_URL = "jdbc:sqlite:" + DEFAULT_DB;

    public final String url;
    
    //Builds database object using default URL
    EmployeeDB() { this(DEFAULT_URL); }
    EmployeeDB(String url) { this.url = url; }

    
    public static void main(String args[]){
        new EmployeeDB().runTest();
    }
    
    public void createNewDatabase() {
        try (Connection con = connect()) {
            if (con != null) {
                DatabaseMetaData meta = con.getMetaData();
                //System.out.println("The driver name is " + meta.getDriverName());
                //System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    private Connection connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DEFAULT_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println("Connected to Employee Database!");
        return con;
    }

    //Creates the table for Employees
    public void createNewTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEES( "
                + " ID             INT PRIMARY KEY NOT NULL, "
                + " NAME           TEXT            NOT NULL, "
                + " AGE            INT             NOT NULL, "
                + " SALARY         REAL            NOT NULL, "
                + " POSITION       TEXT            NOT NULL) ";

        try (Connection con = connect();
                Statement stmt = con.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Emplyee Table is active!");
    }

    public void readDatabase(){
        //Displays all the records in the EMPOYEES table
        String sql = "SELECT * FROM EMPLOYEES;";
        try (Connection con = connect();
            Statement stmt = con.createStatement()) {
            
            //Execute the query and store in ResultSet
            ResultSet resultsFromQuery = stmt.executeQuery(sql);

            while(resultsFromQuery.next()){
                System.out.println();

                //Get the information from the record
                int id = resultsFromQuery.getInt("ID");
                String name = resultsFromQuery.getString("NAME");
                int age = resultsFromQuery.getInt("AGE");
                float salary = resultsFromQuery.getFloat("SALARY");
                String position = resultsFromQuery.getString("POSITION");

                //Prints to terminal
                System.out.println("ID: " + id);
                System.out.println("NAME: " + name);
                System.out.println("AGE: " + age);
                System.out.println("SALARY: " + salary);
                System.out.println("POSITION: " + position);  
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
    }

    public void insertEmployee(int id, String name, int age, float salary, String position){
        String sql = "INSERT INTO EMPLOYEES (ID, NAME, AGE, SALARY, POSITION)" + 
                    "VALUES ("
                    + "'" +  id + "'" + "," 
                    + "'" +  name + "'" + ","
                    + age + ","
                    + salary + ","
                    + "'" +  position + "'" + ");";

        try (Connection con = connect();
            Statement stmt = con.createStatement()) {
            
            //Add the record
            stmt.executeUpdate(sql);

            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Emplyee " + name + " added!");
    }

    public void deleteEmployee(int id){
        String sql = "DELETE from EMPLOYEES where ID = "
                    + id + ";";
        try (Connection con = connect();
            Statement stmt = con.createStatement()) {
            
            //Remove the record
            stmt.executeUpdate(sql);
            System.out.println("Emplyee with ID: " + id + " deleted!");

            //Print database to show changes
            readDatabase();

            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }

    public void updateEmployee(int id, String name, int age, float salary, String position){
        String sql = "UPDATE EMPLOYEES set "
                    + " NAME = " + "'" + name + "'" + ","
                    + " AGE = " + age + ","
                    + " SALARY = " + salary + ","
                    + " POSITION = " + "'" + position + "'"
                    + " where ID = " + id + ";";
                
        try (Connection con = connect();
            Statement stmt = con.createStatement()) {
            
            //Update the record
            stmt.executeUpdate(sql);
            System.out.println("Employee with id: " + id + " updated!");

            //Print database to show changes
            readDatabase();

            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }
    
    private void runTest(){
        createNewDatabase();
        createNewTable();
        insertEmployee(0,"RAY",24,30000,"Worker");
        updateEmployee(0,"Gray",25,25000, "Worker");
        insertEmployee(2,"Chewy",19,3500,"Worker");
        readDatabase();
        deleteEmployee(0);
        deleteEmployee(2);
    }
}
