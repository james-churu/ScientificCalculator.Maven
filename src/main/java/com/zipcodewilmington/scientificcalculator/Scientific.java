package com.zipcodewilmington.scientificcalculator;

public class Scientific {
    public int square(double x ){

        return  (int) Math.pow(x,2);
    }

    public int squareRoot( double x){
        return (int) Math.sqrt(x);
    }

    public double inverse ( int x){
        Basic basic = new Basic();
        return basic.divide(1,x);
    }
public double switchSign (double  x){
    return x*(-1);

}
public double sinX( double x ){
        double radians=Math.toRadians(x);

        return Math.sin(radians);
}

    public double sin( double y ){
        double radians=Math.toRadians(y);

        return Math.sin(radians);
    }


    public double cos( double x ){
        double radians=Math.toRadians(x);

        return Math.cos(radians);
    }

    public double tangent( double x){
        double radians=Math.toRadians(x);

        return Math.tan(radians);


    }
    public double  inverseSine ( double x){
        return Math.asin(sin(x));
    }
    public double  inverseCosine ( double x){
        return Math.acos(sin(x));
    }
    public double  inverseTangent ( double x){
        return Math.atan(sin(x));
    }
    public double factorial( double x){
        double num=0;
        double damn=0;
     for ( double i=x; i>0; i--){
         double previousNum=i-1;
         num=previousNum*i;
         damn+=num;

     } return num;
    }

}
