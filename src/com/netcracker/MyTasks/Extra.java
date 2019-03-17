package com.netcracker.MyTasks;

public class Extra {

    private static final double EPS = 0.0000000001;

    public static boolean isEqual(double a, double b) {
        return (Math.abs(a - b) < EPS);
    }

}