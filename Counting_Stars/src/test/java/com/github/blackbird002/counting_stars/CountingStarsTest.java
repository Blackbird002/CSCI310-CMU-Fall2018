/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blackbird002.counting_stars;

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
public class CountingStarsTest {
    
    public CountingStarsTest() {
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
     * Test of main method, of class CountingStars.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        CountingStars.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of go method, of class CountingStars.
     */
    @Test
    public void testGo() throws Exception {
        System.out.println("go");
        CountingStars instance = new CountingStars();
        instance.go();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /*
    #################---
    ##-###############--
    #---################
    ##-#################
    ########---#########
    #######-----########
    ########---#########
    ##################--
    #################---
    ##################-#
    */
    
    @Test
    public void testCase1() throws Exception{
        CountingStars instance = new CountingStars();
        instance.rows = 10;
        instance.cols = 20;
        instance.picture = new boolean[10][20];
        int row = 0;
        instance.picture[row++] = instance.parseRow("#################---");
        instance.picture[row++] = instance.parseRow("##-###############--");
        instance.picture[row++] = instance.parseRow("#---################");
        instance.picture[row++] = instance.parseRow("##-#################");
        instance.picture[row++] = instance.parseRow("########---#########");
        instance.picture[row++] = instance.parseRow("#######-----########");
        instance.picture[row++] = instance.parseRow("########---#########");
        instance.picture[row++] = instance.parseRow("##################--");
        instance.picture[row++] = instance.parseRow("#################---");
        instance.picture[row++] = instance.parseRow("##################-#");

        instance.solve();
        assertEquals(4, instance.stars);
        
    }
    
    /*
    
    #-########
    ----------
    #-########
    */
    
    @Test
    public void testCase2() throws Exception{
        CountingStars instance = new CountingStars();
        instance.rows = 3;
        instance.cols = 10;
        instance.picture = new boolean[3][10];
        int row = 0;
        instance.picture[row++] = instance.parseRow("#-########");
        instance.picture[row++] = instance.parseRow("----------");
        instance.picture[row++] = instance.parseRow("#-########");
        

        instance.solve();
        assertEquals(1, instance.stars);
        
    }

    /**
     * Test of solve method, of class CountingStars.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        CountingStars instance = new CountingStars();
        instance.solve();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseRow method, of class CountingStars.
     */
    @Test
    public void testParseRow() {
        CountingStars instance = new CountingStars();
        boolean[] result = instance.parseRow("#-########");
        boolean[] expect = new boolean[] {false,true,false,false,false,false,false,false,false,false};
        assertArrayEquals(expect,result);
    }
    
}
