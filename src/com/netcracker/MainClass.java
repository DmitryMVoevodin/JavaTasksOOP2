package com.netcracker;

import com.netcracker.MyTasks.Ball;
import com.netcracker.MyTasks.Container;
import com.netcracker.MyTasks.MyComplex;
import com.netcracker.MyTasks.MyPolynomial;

public class MainClass {

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

        //Task 2 (MyPolynomial class)
        beginTitle(2);

            MyPolynomial[] p = new MyPolynomial[10];
            p[0] = new MyPolynomial(2,0,0,3,-9.3);
            p[1] = new MyPolynomial(0,3,-2.2,8,0,0,3,0,0);
            p[2] = new MyPolynomial(-2.77,3,0);
            p[3] = new MyPolynomial();
            p[4] = new MyPolynomial(-1);
            p[5] = new MyPolynomial(1);
            p[6] = new MyPolynomial(1,0,-1,0,1,-6.0,-1.0);
            p[7] = new MyPolynomial(-1,0,0,0,0,0,1.0);
            p[8] = new MyPolynomial();
            p[9] = new MyPolynomial(2,-4,0,3);
            for(int i = 0; i < p.length; ++i) {
                System.out.println(p[i] +
                        ", Degree = " + p[i].getDegree() +
                        ", f(" + (-5 + i) + ") = " + (((int) Math.round(p[i].evaluate(-5 + i) * 100.0)) / 100.0));
            }

            System.out.println("\nMethod \"add()\"" +
                    "\nFirst:  " + p[0] + "\nSecond: " + p[1] + "\nResult: " + p[0].add(p[1]));
            System.out.println("\nMethod \"add()\"" +
                    "\nFirst:  " + p[2] + "\nSecond: " + p[2] + "\nThird: " + p[2] + "\nResult: " + p[2].add(p[2]).add(p[2]));
            System.out.println("\nMethod \"multiply()\" - we use the Fast Fourier Transform O(N*lnN)" +
                    "\nFirst:  " + p[9] + "\nSecond: " + p[6] + "\nResult: " + p[9].multiply(p[6]));
            System.out.println("\nMethod \"multiply2()\" - we use O(N^2)" +
                    "\nFirst:  " + p[9] + "\nSecond: " + p[6] + "\nResult: " + p[9].multiply2(p[6]));

            System.out.println("\n\nEquals and HashCode:");
            MyPolynomial pol1 = new MyPolynomial(2, -2, 4, 1, 1);
            MyPolynomial pol2 = pol1;
            MyPolynomial pol3 = new MyPolynomial(2, -2, 4, 1, 1);
            MyPolynomial pol4 = new MyPolynomial(2, -2, 4, 0, 1);
            System.out.println("pol1: " + pol1 + ", hashCode = " + pol1.hashCode());
            System.out.println("pol2: " + pol2 + ", hashCode = " + pol2.hashCode());
            System.out.println("pol3: " + pol3 + ", hashCode = " + pol3.hashCode());
            System.out.println("pol4: " + pol4 + ", hashCode = " + pol4.hashCode());
            System.out.println("pol1 equals pol2? " + pol1.equals(pol2) + ";   pol1 == pol2? " + (pol1 == pol2));
            System.out.println("pol1 equals pol3? " + pol1.equals(pol3) + ";   pol1 == pol3? " + (pol1 == pol3));
            System.out.println("pol1 equals pol4? " + pol1.equals(pol4) + ";   pol1 == pol4? " + (pol1 == pol4));

        endTitle();


        //Task 3 (Ball class & Container class)
        beginTitle(3);

            Container container = new Container(0,5,10,5);
            System.out.println(container + ", i.e. x1 = " + container.getX() + ", y1 = " + container.getY());
            System.out.println("width = " + container.getWidth() + ", height = " + container.getHeight());
            Ball ball = new Ball(0.0f,0.0f,1,2,90);
            System.out.println("ball: " + ball);
            System.out.println("x = " + ball.getX() + ", y = " + ball.getY());
            System.out.println("xDelta = " + ball.getXDelta() + ", yDelta = " + ball.getYDelta());
            System.out.println("radius = " + ball.getRadius());
            ball.setX(0.1f); ball.setY(0.2f); ball.setRadius(2); ball.setXDelta(1); ball.setYDelta(1);
            System.out.println("After changes: ");
            System.out.println("ball: " + ball);
            System.out.println("x = " + ball.getX() + ", y = " + ball.getY());
            System.out.println("xDelta = " + ball.getXDelta() + ", yDelta = " + ball.getYDelta());
            System.out.println("radius = " + ball.getRadius());
            System.out.println("In the container? " + container.collides(ball));
            ball.setX(5.0f); ball.setY(2.5f);
            System.out.println("After changes: ");
            System.out.println("ball: " + ball);
            System.out.println("In the container? " + container.collides(ball));

            System.out.println("\n\nEquals and HashCode:");
            Ball ball1 = new Ball(2.0f, -2.0f, 4, 1, 45);
            Ball ball2 = ball1;
            Ball ball3 = new Ball(2.0f, -2.0f, 4, 1, 45);
            Ball ball4 = new Ball(2.0f, -2.0f, 4, 4, 45);
            System.out.println("ball1: " + ball1 + ", hashCode = " + ball1.hashCode());
            System.out.println("ball2: " + ball2 + ", hashCode = " + ball2.hashCode());
            System.out.println("ball3: " + ball3 + ", hashCode = " + ball3.hashCode());
            System.out.println("ball4: " + ball4 + ", hashCode = " + ball4.hashCode());
            System.out.println("ball1 equals ball2? " + ball1.equals(ball2) + ";   ball1 == ball2? " + (ball1 == ball2));
            System.out.println("ball1 equals ball3? " + ball1.equals(ball3) + ";   ball1 == ball3? " + (ball1 == ball3));
            System.out.println("ball1 equals ball4? " + ball1.equals(ball4) + ";   ball1 == ball4? " + (ball1 == ball4));

            System.out.println("\n\nEquals and HashCode:");
            Container cont1 = new Container(1, 2, 4, 5);
            Container cont2 = cont1;
            Container cont3 = new Container(1, 2, 4, 5);
            Container cont4 = new Container(1, 2, 3, 5);
            System.out.println("cont1: " + cont1 + ", hashCode = " + cont1.hashCode());
            System.out.println("cont2: " + cont2 + ", hashCode = " + cont2.hashCode());
            System.out.println("cont3: " + cont3 + ", hashCode = " + cont3.hashCode());
            System.out.println("cont4: " + cont4 + ", hashCode = " + cont4.hashCode());
            System.out.println("cont1 equals cont2? " + cont1.equals(cont2) + ";   cont1 == cont2? " + (cont1 == cont2));
            System.out.println("cont1 equals cont3? " + cont1.equals(cont3) + ";   cont1 == cont3? " + (cont1 == cont3));
            System.out.println("cont1 equals cont4? " + cont1.equals(cont4) + ";   cont1 == cont4? " + (cont1 == cont4));

        endTitle();

    }

    //For some sort of design
    private static void beginTitle(int num) {
        System.out.println("***************************** Task " + num + " *****************************");
    }
    private static void endTitle() {
        System.out.println("******************************************************************" + "\n");
    }

}