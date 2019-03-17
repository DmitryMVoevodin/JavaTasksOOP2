package com.netcracker.MyTasks;

public class Ball {

    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        //direction in degrees
        this.xDelta = (float)(speed * Math.cos(Math.PI * direction / 180));
        this.yDelta = (float)(-speed * Math.sin(Math.PI * direction / 180));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return ("Ball[(" + x + ", " + y + "), speed=(" + xDelta + ", " + yDelta + ")]");
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof Ball)) return false;
        Ball obj1 = (Ball) obj;
        return ((Extra.isEqual(this.x, obj1.x)) && (Extra.isEqual(this.y, obj1.y)) &&
                (Extra.isEqual(this.xDelta, obj1.xDelta)) && (Extra.isEqual(this.yDelta, obj1.yDelta)) &&
                (this.radius == obj1.radius));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        result = 31 * result + radius;
        result = 31 * result + Float.floatToIntBits(xDelta);
        result = 31 * result + Float.floatToIntBits(yDelta);
        return result;
    }

}