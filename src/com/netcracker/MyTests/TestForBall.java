package com.netcracker.MyTests;

import com.netcracker.MyTasks.Ball;
import com.netcracker.MyTasks.Container;

public class TestForBall {

    public static void main(String[] args) {
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