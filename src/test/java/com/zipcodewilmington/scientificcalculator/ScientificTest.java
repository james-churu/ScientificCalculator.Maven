package com.zipcodewilmington.scientificcalculator;


import org.junit.Assert;
import org.junit.Test;

public class ScientificTest {

    @Test
    public void squareTest() {
        Scientific scientific = new Scientific();
        int expected = 4;
        int actual= scientific.square(2);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void sinTest() {
        Scientific scientific = new Scientific();
        double expected = 0.7071067811865475;
        double actual= scientific.sinX(45.0);
        Assert.assertEquals(expected,actual,0);
        // delta is the percision lost
    }
    /*@Test
    public void factorialTest(){
        Scientific scientific = new Scientific();
        double expected = 24;
        double actual= scientific.factorial(4);
        Assert.assertEquals(expected, actual,0);

    }*/



}
