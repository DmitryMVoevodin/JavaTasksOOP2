package com.netcracker.MyTasks;

public class MyComplex {

    private double real;
    private double imag;

    public MyComplex(){
        setValue(0,0);
    }

    public MyComplex(double real, double imag) {
        setValue(real, imag);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if(Extra.isEqual(real,0) && Extra.isEqual(imag,0)) {
            return "(0)";
        } else if(Extra.isEqual(real,0)) {
            return ("(" + imag + "i)");
        } else if(Extra.isEqual(imag,0)) {
            return ("(" + real + ")");
        } else {
            String s = new String((imag > 0) ? "+" : "");
            return ("(" + real + s + imag + "i)");
        }
    }

    public boolean isReal(){
        return (!Extra.isEqual(real,0));
    }

    public boolean isImaginary(){
        return (!Extra.isEqual(imag,0));
    }

    public boolean equals(double real, double imag) {
        return ((Extra.isEqual(this.real, real)) && (Extra.isEqual(this.imag, imag)));
    }

    @Override
    public boolean equals(Object another) {
        if(another == this) return true;
        if(another == null) return false;
        if(!(another instanceof MyComplex)) {
            return false;
        }
        MyComplex obj = (MyComplex) another;
        return this.equals(obj.real, obj.imag);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long longHash = Double.doubleToLongBits(real);
        result = 31 * result + ((int)(longHash ^ (longHash >>> 32)));
        longHash = Double.doubleToLongBits(imag);
        result = 31 * result + ((int)(longHash ^ (longHash >>> 32)));
        return result;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2.0) + Math.pow(imag, 2.0));
    }

    public double argument() {
        double arg = 0;
        try {
            arg = Math.asin(imag / magnitude());
        } catch (ArithmeticException e) {
            arg = 0;
        }
        return arg;
    }

    public MyComplex add(MyComplex right) {
        double ReAdd = (right != null) ? right.real : 0;
        double ImAdd = (right != null) ? right.imag : 0;
        this.real += ReAdd;
        this.imag += ImAdd;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        double ReAdd = (right != null) ? right.real : 0;
        double ImAdd = (right != null) ? right.imag : 0;
        return new MyComplex((this.real + ReAdd), (this.imag + ImAdd));
    }

    public MyComplex subtract(MyComplex right) {
        double ReSub = (right != null) ? right.real : 0;
        double ImSub = (right != null) ? right.imag : 0;
        this.real -= ReSub;
        this.imag -= ImSub;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        double ReSub = (right != null) ? right.real : 0;
        double ImSub = (right != null) ? right.imag : 0;
        return new MyComplex((this.real - ReSub), (this.imag - ImSub));
    }

    public MyComplex multiply(MyComplex right) {
        double ReMul = (right != null) ? right.real : 0;
        double ImMul = (right != null) ? right.imag : 0;
        double Re = this.real * ReMul - this.imag * ImMul;
        double Im = this.real * ImMul + ReMul * this.imag;
        this.setValue(Re, Im);
        return this;
    }

    public MyComplex multiplyNew(MyComplex right) {
        double ReMul = (right != null) ? right.real : 0;
        double ImMul = (right != null) ? right.imag : 0;
        double Re = this.real * ReMul - this.imag * ImMul;
        double Im = this.real * ImMul + ReMul * this.imag;
        return new MyComplex(Re, Im);
    }

    public MyComplex divide(MyComplex right) {
        double ReDiv = (right != null) ? right.real : 0;
        double ImDiv = (right != null) ? right.imag : 0;
        double Re, Im;
        try {
            Re = this.real * ReDiv + this.imag * ImDiv;
            Im = ReDiv * this.imag - this.real * ImDiv;
            double r = (Math.pow(ReDiv, 2.0) + Math.pow(ImDiv, 2.0));
            Re /= r;
            Im /= r;
        } catch (ArithmeticException e) {
            Re = Im = 0;
        }
        this.setValue(Re, Im);
        return this;
    }

    public MyComplex divideNew(MyComplex right) {
        double ReDiv = (right != null) ? right.real : 0;
        double ImDiv = (right != null) ? right.imag : 0;
        double Re, Im;
        try {
            Re = this.real * ReDiv + this.imag * ImDiv;
            Im = ReDiv * this.imag - this.real * ImDiv;
            double r = (Math.pow(ReDiv, 2.0) + Math.pow(ImDiv, 2.0));
            Re /= r;
            Im /= r;
        } catch (ArithmeticException e) {
            Re = Im = 0;
        }
        return new MyComplex(Re, Im);
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }

}