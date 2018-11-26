package assignment5.blackbird002.github.packagecom.fibonaccicalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void calculateFib() {
        int expected = 832040;
        int delta = 1;

        //The nth Fibonacci term
        int input = 30;

        //The result from the test
        MainActivity TestActivity= new MainActivity();
        int output = TestActivity.calculateFib(input);

        assertEquals(expected, output, delta);
    }

    @Test
    public void calculateFibCase2() {
        int expected = 9227465;
        int delta = 1;

        //The nth Fibonacci term
        int input = 35;

        //The result from the test
        MainActivity TestActivity= new MainActivity();
        int output = TestActivity.calculateFib(input);

        assertEquals(expected, output, delta);
    }

    @Test
    public void calculateFibCase3() {
        int expected = 144;
        int delta = 1;

        //The nth Fibonacci term
        int input = 12;

        //The result from the test
        MainActivity TestActivity= new MainActivity();
        int output = TestActivity.calculateFib(input);

        assertEquals(expected, output, delta);
    }
}