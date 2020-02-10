package com.zipcodewilmington.scientificcalculator;

public class Scientific {
    public double square(double x) {

        return Math.pow(x, 2);
    }

    public double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public double inverse(double x) {
        Basic basic = new Basic();
        return basic.divide(1, x);
    }

    public double switchSign(double x) {
        return x * (-1);

    }


    public double sine(double y) {
        double radians = Math.toRadians(y);

        return Math.sin(radians);
    }


    public double cosine(double x) {
        double radians = Math.toRadians(x);

        return Math.cos(radians);
    }


    public double tangent(double x) {
        double radians = Math.toRadians(x);

        return Math.tan(radians);


    }

    public double inverseSine(double x) {
        return Math.asin(x);
    }

    public double inverseCosine(double x) {
        return Math.acos(sine(x));
    }

    public double inverseTangent(double x) {
        return Math.atan(x);
    }

    public double factorial(double x) {
        double num = 1;

        for (double i = x; i > 0; i--) {
            num = num * i;
        }
        return num;
    }

    public double switchUnitMode(double x, double y) {
        if (1 == y) {
            x = Math.toRadians(x);

        } else if (2 == y) {
            x = Math.toDegrees(x);
        }
        return x;

    }
}