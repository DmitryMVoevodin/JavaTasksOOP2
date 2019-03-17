package com.netcracker.MyTests;

import com.netcracker.MyTasks.MyComplex;

public class TestForMyComplex {

    public static void main(String[] args) {
        //Task 1 (MyComplex class)
        beginTitle(1);

            MyComplex[] c = new MyComplex[10];
            c[0] = new MyComplex();
            c[1] = new MyComplex(8.8, 2);
            c[2] = new MyComplex(-3, 10);
            c[3] = new MyComplex(9, -10);
            c[4] = new MyComplex(0, 1);
            c[5] = new MyComplex(0, -1);
            c[6] = new MyComplex(8, 0);
            c[7] = new MyComplex(-8, 0);
            c[8] = new MyComplex(-1, 6);
            c[9] = new MyComplex(1, 3);
            for(int i = 0; i < c.length; ++i) {
                System.out.println(c[i] +
                        ", Magnitude = " + (((int) Math.round(c[i].magnitude() * 100.0)) / 100.0) +
                        ", Argument = " + (((int) Math.round(c[i].argument() * 100.0)) / 100.0) +
                        ", conjugate(): " + c[i].conjugate() +
                        ", isReal() = " + c[i].isReal() +
                        ", isImaginary() = " + c[i].isImaginary());
            }

            System.out.println("\nBefore changes: " + c[1]);
            c[1].setImag(8); c[1].setReal(9);
            System.out.println("After changes setImag(8), setReal(9): " + c[1]);
            System.out.println("\nBefore changes: " + c[2]);
            c[2].setValue(9,-10);
            System.out.println("After changes setValue(9,-10): " + c[2]  +
                 ", i.e. getReal() = " + c[2].getReal() + ", getImage() = " +c[2].getImag() );

            System.out.println();
            c[9] = c[8];
            System.out.println(c[8] + " == " + c[9] + "? " + (c[8] == c[9]));
            System.out.println(c[8] + " equals " + c[9] + "? " + c[8].equals(c[9]));
            System.out.println("The first hashCode() = " + c[8].hashCode() + ", the second hashCode() = " + c[9].hashCode());

            System.out.println();
            System.out.println(c[1] + " == " + c[2] + "? " + (c[1] == c[2]));
            System.out.println(c[1] + " equals " + c[2] + "? " + c[1].equals(c[2]));
            System.out.println("The first hashCode() = " + c[1].hashCode() + ", the second hashCode() = " + c[2].hashCode());

            System.out.println();
            System.out.println(c[3] + " == " + c[2] + "? " + (c[3] == c[2]));
            System.out.println(c[3] + " equals " + c[2] + "? " + c[3].equals(c[2]));
            System.out.println("The first hashCode() = " + c[3].hashCode() + ", the second hashCode() = " + c[2].hashCode());

            System.out.println("\nMethod add():" + "\nFirst:  " + c[1] + "Second: " + c[2]);
            c[1].add(c[2]);
            System.out.println("First after changes: " + c[1]);

            System.out.println("\nMethod subtract():" + "\nFirst:  " + c[1] + "Second: " + c[2]);
            c[1].subtract(c[2]);
            System.out.println("First after changes: " + c[1]);

            System.out.println("\nMethod addNew():" + "\nFirst:  " + c[1] + "Second: " + c[2]);
            MyComplex cc = c[1].addNew(c[2]);
            System.out.println("First after changes: " + c[1] + ", Result=" + cc);

            System.out.println("\nMethod subtractNew():" + "\nFirst:  " + c[1] + "Second: " + c[2]);
            cc = c[1].subtractNew(c[2]);
            System.out.println("First after changes: " + c[1] + ", Result=" + cc);

            System.out.println("\nMethod multiply():"  + "\nFirst:  " + c[1] + "Second: " + c[2]);
            c[1].multiply(c[2]);
            System.out.println("First after changes: " + c[1]);

            System.out.println("\nMethod divide():" + "\nFirst:  " + c[1] + "Second: " + c[2]);
            c[1].divide(c[2]);
            System.out.println("First after changes: " + c[1]);


            System.out.println("\n\nEquals and HashCode:");
            MyComplex com1 = new MyComplex(7, -2);
            MyComplex com2 = com1;
            MyComplex com3 = new MyComplex(7, -2);
            MyComplex com4 = new MyComplex(6, -2);
            System.out.println("com1: " + com1 + ", hashCode = " + com1.hashCode());
            System.out.println("com2: " + com2 + ", hashCode = " + com2.hashCode());
            System.out.println("com3: " + com3 + ", hashCode = " + com3.hashCode());
            System.out.println("com4: " + com4 + ", hashCode = " + com4.hashCode());
            System.out.println("com1 equals com2? " + com1.equals(com2) + ";   com1 == com2? " + (com1 == com2));
            System.out.println("com1 equals com3? " + com1.equals(com3) + ";   com1 == com3? " + (com1 == com3));
            System.out.println("com1 equals com4? " + com1.equals(com4) + ";   com1 == com4? " + (com1 == com4));

        endTitle();

        //**********************************************************************************
    }

    //For some sort of design
    private static void beginTitle(int num) {
        System.out.println("***************************** Task " + num + " *****************************");
    }
    private static void endTitle() {
        System.out.println("******************************************************************" + "\n");
    }

}