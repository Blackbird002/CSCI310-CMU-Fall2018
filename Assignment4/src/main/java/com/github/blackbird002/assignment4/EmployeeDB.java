package com.github.blackbird002.assignment4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
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
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
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
        System.out.println("Connected to Employee Database!");
        return con;
    }
    
    private void runTest(){
        createNewDatabase();
    }


    
}
