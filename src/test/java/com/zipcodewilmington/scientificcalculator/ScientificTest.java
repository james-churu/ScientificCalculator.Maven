package com.zipcodewilmington.scientificcalculator;


import org.junit.Assert;
import org.junit.Test;

public class ScientificTest {

    @Test
    public void squareTest() {
        Scientific scientific = new Scientific();
        double expected = 4;
        double actual = scientific.square(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void squareRoot() {
        Scientific scientific = new Scientific();
        double expected = 12;
        double actual = scientific.squareRoot(144);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inverseTest() {
        Scientific scientific = new Scientific();
        double expected = 1 / 8;
        double actual = scientific.inverse(8);
        Assert.assertEquals(expected, actual, 5);
    }

    @Test
    public void switchSignTest() {
        Scientific scientific = new Scientific();
        double expected = 8;
        double actual = scientific.switchSign(-8);
        Assert.assertEquals(expected, actual, 5);

        expected = -8;
        actual = scientific.switchSign(8);
        Assert.assertEquals(expected, actual, 5);
    }

    @Test
    public void sinTest() {
        Scientific scientific = new Scientific();
        double expected = 0.7071067811865475;
        double actual = scientific.sine(45.0);
        Assert.assertEquals(expected, actual, 0);
        // delta is the percision lost
    }

    @Test
    public void cosTest() {
        Scientific scientific = new Scientific();
        double expected = 0.7071067811865475;
        double actual = scientific.cosine(45.0);
        Assert.assertEquals(expected, actual, 5);
        // delta is the percision lost
    }

    @Test
    public void tanTest() {
        Scientific scientific = new Scientific();
        double expected = 0.7071067811865475;
        double actual = scientific.tangent(45.0);
        Assert.assertEquals(expected, actual, 5);
        // delta is the percision lost
    }

    @Test
    public void factorialTest() {
        Scientific scientific = new Scientific();
        double expected = 24;
        double actual = scientific.factorial(4);
        Assert.assertEquals(expected, actual, 0);

    }

    @Test
    public void inverseSineTest() {
        Scientific scientific = new Scientific();
        double expected = 0.7853981633974482;
        double actual = scientific.inverseSine(0.7071067811865475);
        Assert.assertEquals(expected, actual, 0);

    }
    @Test
    public void inverseCosineTest() {
        Scientific scientific = new Scientific();
        double expected = 1.5707963267948966;
        double actual = scientific.inverseCosine(0);
        Assert.assertEquals(expected, actual, 0);

    }
    @Test
    public void inverseTangentTest() {
        Scientific scientific = new Scientific();
        double expected = 0.8881737743776796;
        double actual = scientific.inverseTangent(1.23);
        Assert.assertEquals(expected, actual, 0);

    }
    @Test
    public void switchUnitModeTest() {
        Scientific scientific = new Scientific();
         double expected = 1;
         double actual = scientific.switchUnitMode(1.0,  2.0);
        Assert.assertEquals(expected, actual, 0);

    }

}
