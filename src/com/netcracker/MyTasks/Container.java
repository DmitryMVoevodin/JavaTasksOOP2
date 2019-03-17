package com.netcracker.MyTasks;

import com.netcracker.MyTasks.Ball;

public class Container {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        x1 = x;
        y1 = y;
        x2 = x + width;
        y2 = y - height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return (x2 - x1);
    }

    public int getHeight() {
        return (y1 - y2);
    }

    public boolean collides(Ball ball) {
        if(ball == null) {
            return false;
        }
        float x = ball.getX();
        float y = ball.getY();
        int r = ball.getRadius();
        if((x + r > x2) || (x - r < x1) || (y + r > y1) || (y - r < y2) ||
                (Extra.isEqual(x + r, x2)) ||
                (Extra.isEqual(x - r, x1)) ||
                (Extra.isEqual(y + r, y1)) ||
                (Extra.isEqual(y - r, y2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Container[(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")]");
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof Container)) return false;
        Container obj1 = (Container) obj;
        return ((this.x1 == obj1.x1) &&
                (this.x2== obj1.x2) &&
                (this.y1 == obj1.y1) &&
                (this.y2 == obj1.y2));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x1;
        result = 31 * result + y1;
        result = 31 * result + x2;
        result = 31 * result + y2;
        return result;
    }

}