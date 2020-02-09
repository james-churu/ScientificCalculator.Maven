package com.zipcodewilmington.scientificcalculator;

import org.junit.Assert;
import org.junit.Test;


public class BasicTest {

    @Test
     public void addTest() {
        Basic basic = new Basic();
        int expected = 10;

        int actual= basic.add(5,5);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void multiplyTest() {
        Basic basic = new Basic();
        int expected = 12;

        int actual= basic.multiply(6,2);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void divideTest() {
        Basic basic = new Basic();
        int expected = 1;

        int actual= basic.divide(5,5);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subtractTest() {
        Basic basic = new Basic();
        int expected = 0;

        int actual= basic.subtract(5,5);

        Assert.assertEquals(expected,actual);

    }
}