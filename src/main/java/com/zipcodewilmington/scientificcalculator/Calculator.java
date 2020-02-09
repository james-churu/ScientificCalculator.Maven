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
    public static double numberInput() {
        int x = 1;
        double entered = 0;

        do {
            try {
                Scanner attempt1 = new Scanner(System.in);
                entered = attempt1.nextDouble();
                x = 0;
                if (entered == 0) {
                    System.out.print("Sorry 0 not valid    : ");
                    x = 1;
                }
            } catch (InputMismatchException e) {
                System.out.print("Error : Enter a #    : ");
            }

        } while (x == 1);

        return entered;
    }

    //***************************Taking an operator****************************
// String[] = new String[] {"+","-","/","*"};
    public String operatorInput() {

        String[] basic = {"+", "-", "/", "*"};
        String[] sci = {"square()", "squareRoot()", "inverse()", "switchSign()", "sine()", "cosine()", "tangent()", "inverseSine()", "inverseCosine()", "inverseTangent()", "factorial()"};
        String[] quick = {"square()", "squareRoot()", "sine()", "cosine()", "tangent()", "inverseSine()", "inverseCosine()", "inverseTangent()"};
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
                    System.out.println("Invalid Input - Enter an Operator : ");
                }

            } catch (InputMismatchException e) {
                System.out.print("Invalid Input - Enter an operator : ");
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
                loopExit = 2;
            } else {
                System.out.print("Sorry invalid input : Try again : ");

                loopExit = 0;

                whichCalc = calcChoice();
            }
        }


        Calculator user = new Calculator();

        double starterNum;
        double savedNum;


        if (loopExit == 1) {

            System.out.print("Hello Please provide your starting Num : ");
            starterNum = numberInput();
            user.currentVal = starterNum;

            System.out.print("Hello Please provide a number to save  : ");
            savedNum = numberInput();
            user.savedVal = savedNum;

            int keepGoing = 1;
            while (keepGoing > 0) {
                System.out.println("Current Val          : " + user.currentVal);
                System.out.print("Enter Operator       : ");
                String userOperator = user.operatorInput();
                System.out.print("Enter Next Number    : ");
                double userNextNum = user.numberInput();
                System.out.println("Current Val          : 5");

                keepGoing = 0;
                

            }
        }

    }

}



