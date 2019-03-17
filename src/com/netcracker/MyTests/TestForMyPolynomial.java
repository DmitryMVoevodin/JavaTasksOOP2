package com.netcracker.MyTests;

import com.netcracker.MyTasks.MyPolynomial;

public class TestForMyPolynomial {

    public static void main(String[] args) {
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
    }

    //For some sort of design
    private static void beginTitle(int num) {
        System.out.println("***************************** Task " + num + " *****************************");
    }
    private static void endTitle() {
        System.out.println("******************************************************************" + "\n");
    }

}