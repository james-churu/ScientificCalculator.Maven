package com.zipcodewilmington.scientificcalculator;


import org.junit.Assert;
import org.junit.Test;


public class BasicTest {

    @Test
    public void addTest() {
        Basic basic = new Basic();
        double expected = 10;

        double actual= basic.add(5,5);

        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void multiplyTest() {
        Basic basic = new Basic();
        double expected = 12;

        double actual= basic.multiply(6,2);

        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void divideTest() {
        Basic basic = new Basic();
        double expected = 1;

        double actual= basic.divide(5,5);

        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void subtractTest() {
        Basic basic = new Basic();
        double expected = 0;

        double actual= basic.subtract(5,5);

        Assert.assertEquals(expected,actual,0);

    }
}
