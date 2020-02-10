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

                if (inputo.equals("MRC")){
                    entered = savedNumber;
                    System.out.println("Using Saved #        : " + savedNumber);
                    x = 4;
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

        String[] basic = {"+", "-", "/", "*"};
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


        System.out.print("Hello which calculator would you like to use ? \n" +
                "Enter ''S'' for Scientific or ''B''  for Basic   : ");

        String whichCalc = calcChoice();
        int loopExit = 0;

        while (loopExit == 0) {

            if (whichCalc.equals("S") || whichCalc.equals("s")) {
                System.out.println("\n" + "Opening Scientific Calc" + "\n");
                //Call Scientific Calc Class
                loopExit = 1;
            } else if (whichCalc.equals("B") || whichCalc.equals("b")) {
                System.out.println("\n" + "Opening Basic Calc");
                //Call Basic Calc Class
                loopExit = 1;
            } else {
                System.out.print("Sorry invalid input : Try again : ");

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

            System.out.print("Hello Please provide your starting Num : ");
            starterNum = numberInput(user.savedVal,user.currentVal);
            user.currentVal = starterNum;

            System.out.print("Hello Please provide a number to save  : ");
            savedNum = numberInput(user.savedVal,user.currentVal);
            user.savedVal = savedNum;

            int keepGoing = 1;
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
                    System.out.println("Current Val          : " + user.currentVal);
                    double userNextNum = user.numberInput(user.savedVal,user.currentVal);
                    user.currentVal = userNextNum;
                }else if(userOperator.equals("exit")){
                    keepGoing = 0;
                }
            }
        }

        System.out.println("\n" + "\n" +"  Calculator Application Closed  " + user.currentVal);

    }



}


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