package com.zipcodewilmington.scientificcalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    //Instance Variables
    double currentVal;
    double savedVal;
    String currentOperand = "";


//***********************Constructor Method *******************************

    public void Calculator(double start, double saved) {
        currentVal = start;
        savedVal = saved;
    }
    //********** TO BINARY ********

    public String toBinary(double recieve){
        Integer convert = (int)Math.round(recieve);
        String bin = Integer.toBinaryString(convert);
        return bin;
    }
    // ******** TO OCTAL *********
    public String toOctal(double recieve){
        Integer convert = (int)Math.round(recieve);
        String bin = Integer.toOctalString(convert);
        return bin;
    }
    // ********* TO DECIMAL ********
    public Integer toDecimal(double recieve) {
        Integer convert = (int) Math.round(recieve);
        return convert;
    }
    // ********* TO HEXADECIMAL *******
    public String toHex(double recieve) {
        Integer convert = (int) Math.round(recieve);
        String bin = Integer.toHexString(convert);
        return bin;
    }

    //***********************Taking a number method;****************************
    public static double numberInput(double savedNumber,double currentValue) {
        int x = 1;
        Double entered = null;
        System.out.print("Enter Next Number    : ");

        do {
            try {
                String inputo = "";
                Scanner attempt1 = new Scanner(System.in);
                inputo  = attempt1.nextLine();

                if (inputo.equals("MRC")) {
                    entered = savedNumber;
                    System.out.println("Using Saved #        : " + savedNumber);
                    x = 4;
                }else if(inputo.equals("random")){
                    entered = Math.random() * (70 - -70);
                    System.out.println("Using Random #       : " + entered);
                    x = 5;
                }else if(inputo.equals("random+")){
                    entered = Math.random() * (101 - 1);
                    System.out.println("Using Random #       : " + entered);
                    x = 5;
                }else if(inputo.equals("random-")){
                    entered = Math.random() * (-100 - -1);
                    System.out.println("Using Random #       : " + entered);
                    x = 5;
                }else {
                    entered = Double.parseDouble(inputo);
                    x = 2;
                }

                if(entered == 0) {
                System.out.print("Sorry 0 not valid    : ");
                x = 1;
                }
            }
            catch (NumberFormatException e){
                System.out.print("Error : Enter a #    : ");
            }

        } while (x == 1);

        if (x == 4){
            return savedNumber;
        }else {
            return entered;
        }
    }
    //***************************Taking an operator****************************
    public String operatorInput() {

        String[] basic = {"+", "-", "/", "*","switchDPM()","switchDPM(binary)","switchDPM(octal)","switchDPM(decimal)","switchDPM(hex)"};
        String[] sci = {"square()", "squareRoot()", "inverse()", "switchSign()", "sine()", "cosine()", "tangent()", "inverseSine()", "inverseCosine()", "inverseTangent()", "factorial()"};
        String[] quick = {"square()", "squareRoot()", "sine()", "cosine()", "tangent()", "inverseSine()", "inverseCosine()", "inverseTangent()","M+","MC","clear","exit"};
        String entered = "";

        boolean exitDoLoop = false;

        do {
            try {
                Scanner attempt1 = new Scanner(System.in);
                entered = attempt1.nextLine();

                for (int i = 0; i < basic.length; i++) {
                    if (entered.equals(basic[i])) {
                        this.currentOperand = entered;
                        exitDoLoop = true;
                    }
                }
                for (int i = 0; i < sci.length; i++) {
                    if (entered.equals(sci[i])) {
                        this.currentOperand = entered;
                        exitDoLoop = true;
                    }
                }
                for (int i = 0; i < quick.length; i++) {
                    if (entered.equals(quick[i])) {
                        this.currentOperand = entered;
                        exitDoLoop = true;
                    }
                }
                if (exitDoLoop != true) {
                    System.out.println("Current Val          : " + this.currentVal);
                    System.out.print("Error : Not Operator : ");
                }

            } catch (InputMismatchException e) {
                System.out.println("Current Val          : " + this.currentVal);
                System.out.print("Error : Not Operator : ");
            }

        } while (exitDoLoop == false);

        return entered;
    }
    // Method for which calculator they want to use ---------------------------
    public static String calcChoice() {
        Scanner userCalcChoice = new Scanner(System.in);
        String choice = userCalcChoice.nextLine();

        return choice;
    }

/////////////////////////-   MAIN METHOD  -////////////////////////////////////

    public static void main(String[] args) {


        System.out.print("  Chose your Calculator  : \n" + "S = Scientific B = Basic : ");

        String whichCalc = calcChoice();
        int loopExit = 0;

        while (loopExit == 0) {

            if (whichCalc.equals("S") || whichCalc.equals("s")) {

                System.out.println("\n" + "* Opening Scientific Calc *" + "\n");
                loopExit = 1;

            } else if (whichCalc.equals("B") || whichCalc.equals("b")) {

                System.out.println("\n" + "*** Opening Basic Calc *** ");
                loopExit = 1;

            } else {
                System.out.print("Invalid Input :          : ");

                loopExit = 0;

                whichCalc = calcChoice();
            }
        }


        Calculator user = new Calculator();
        Basic basic = new Basic();
        Scientific scientific = new Scientific();

        double starterNum;
        double savedNum;


        if (loopExit == 1) {

            System.out.print("# to Save in Memory  : ");
            savedNum = numberInput(user.savedVal,user.currentVal);
            user.savedVal = savedNum;

            System.out.print("Starting Position    : ");
            starterNum = numberInput(user.savedVal,user.currentVal);
            user.currentVal = starterNum;

            int keepGoing = 1;
            String displayMD = "double";
            while (keepGoing > 0) {
                System.out.println("Current Val          : " + user.currentVal);
                System.out.print("Enter Operator       : ");
                String userOperator = user.operatorInput();



                if(userOperator.equals("+")){

                    double userNextNum = user.numberInput(user.savedVal,user.currentVal);
                    double newNum = basic.add(user.currentVal,userNextNum);
                    user.currentVal = newNum;

                }else if(userOperator.equals("-")){

                    double userNextNum = user.numberInput(user.savedVal,user.currentVal);
                    double newNum = basic.subtract(user.currentVal,userNextNum);
                    user.currentVal = newNum;

                }else if(userOperator.equals("*")){

                    double userNextNum = user.numberInput(user.savedVal,user.currentVal);
                    double newNum = basic.multiply(user.currentVal,userNextNum);
                    user.currentVal = newNum;

                }else if(userOperator.equals("/")){

                    double userNextNum = user.numberInput(user.savedVal,user.currentVal);
                    double newNum = basic.divide(user.currentVal,userNextNum);
                    user.currentVal = newNum;
                    //**********************************************
                }else if(userOperator.equals("square()")){

                    double newNum = scientific.square(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("squareRoot()")){

                    double newNum = scientific.squareRoot(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("inverse()")) {

                    double newNum = scientific.inverse(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("switchSign()")) {

                    double newNum = scientific.switchSign(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("sine()")) {

                    double newNum = scientific.sine(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("cosine()")) {

                    double newNum = scientific.cosine(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("tangent()")) {

                    double newNum = scientific.tangent(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("inverseSine()")) {

                    double newNum = scientific.inverseSine(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("inverseCosine()")) {

                    double newNum = scientific.inverseCosine(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("inverseTangent()")) {

                    double newNum = scientific.inverseTangent(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("factorial()")) {

                    double newNum = scientific.factorial(user.currentVal);
                    user.currentVal = newNum;

                }else if(userOperator.equals("M+")) {

                    user.savedVal += user.currentVal;
                    System.out.println("Memory value Now   = : " + user.savedVal);

                }else if(userOperator.equals("MC")) {

                    user.savedVal = 0;
                    System.out.println("Memory value Now   = : " + user.savedVal);

                }else if(userOperator.equals("clear")) {
                    user.currentVal = 0;
                    user.savedVal = 0;
                    System.out.println("*** Memory Cleared **** ------");
                    System.out.println("Saved   Val          : " + user.savedVal);
                    System.out.println("Current Val          : " + user.currentVal);

                    double userNextNum = user.numberInput(user.savedVal,user.currentVal);
                    user.currentVal = userNextNum;

                }else if(userOperator.equals("exit")){

                    keepGoing = 0;

                }else if(userOperator.equals("switchDPM()")){

                    if(displayMD.equals("double")){
                        displayMD = "hexadecimal";
                    }

                    if(displayMD.equals("hexadecimal")) {

                        System.out.println("Binary Conversion  = : " + user.toBinary(user.currentVal));
                        displayMD = "binary";

                    }else if(displayMD.equals("binary")){

                        System.out.println("Octal  Conversion  = : " + user.toOctal(user.currentVal));
                        displayMD = "octal";

                    }else if(displayMD.equals("octal")){

                        System.out.println("Decimal Conversion = : " + user.toDecimal(user.currentVal));
                        displayMD = "decimal";

                    }else if(displayMD.equals("decimal")){

                        System.out.println("Hexadecimal Value  = : " + user.toHex(user.currentVal));
                        displayMD = "hexadecimal";

                    }
                }else if(userOperator.equals("switchDPM(binary)")){
                    System.out.println("Binary Conversion  = : " + user.toBinary(user.currentVal));
                    displayMD = "binary";

                }else if(userOperator.equals("switchDPM(octal)")){
                    System.out.println("Octal  Conversion  = : " + user.toOctal(user.currentVal));
                    displayMD = "octal";

                }else if(userOperator.equals("switchDPM(decimal)")){
                    System.out.println("Decimal Conversion = : " + user.toDecimal(user.currentVal));
                    displayMD = "decimal";

                }else if(userOperator.equals("switchDPM(hex)")){
                    System.out.println("Hexadecimal Value  = : " + user.toHex(user.currentVal));
                    displayMD = "hexadecimal";

                }
            }
        }

        System.out.println("\n" + "           FINAL VALUE           " + "\n");
        System.out.println(             "               "+user.currentVal);
        System.out.println("\n" +"   Calculator Application Closed  " + "\n");
    }

}


//Scrapped Code Below
/*
do {
            try {

                Scanner attempt1 = new Scanner(System.in);
                entered = attempt1.nextDouble();
                x = 0;
                if (entered == 0) {
                    System.out.print("Sorry 0 not valid    : ");
                    x = 1;
                }
                if(entered.toString().equals("MRC")) {
                    entered = savedNumber;
                    x = 4;
                    break;
                }
            }
            catch (InputMismatchException e) {

                if(x == 4){
                    System.out.println("Adding Saved #       : " + savedNumber);
                    break;
                }else {
                    System.out.print("Error : Enter a #    : ");
                }
            }

        } while (x == 1);

        if (x == 4){
            return savedNumber;
        }else {
            return entered;
        }
    }


 */