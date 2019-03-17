package com.netcracker.MyTasks;

import java.util.Arrays;

public class MyPolynomial {

    private double[] coeffs;

    public MyPolynomial() {
        coeffs = new double[1];
        coeffs[0] = 0;
    }

    public MyPolynomial(double ... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        int degree = coeffs.length - 1;
        for(int i = coeffs.length - 1; i >= 0; --i) {
            if (!Extra.isEqual(coeffs[i],0)) {
                degree = i;
                break;
            }
        }
        return degree;
    }

    @Override
    public String toString() {
        String s = new String("");
        int n = getDegree();
        for(int i = n; i >= 0; --i) {
            if((coeffs[i] > 0) && (i != n)) {
                s += "+";
            }
            if(!Extra.isEqual(coeffs[i],0)) {
                s += (((Extra.isEqual(coeffs[i],1)) && (i > 0)) ? "" : (((Extra.isEqual(coeffs[i],-1)) && (i > 0)) ? "-" : coeffs[i]))
                        + ((i != 0) ? "x" : "") + ((i > 1) ? ("^" + i) : "");
            }
        }
        if((n == 0) && (Extra.isEqual(coeffs[0],0))) {
            s = "0";
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof MyPolynomial)) return false;
        MyPolynomial obj1 = (MyPolynomial) obj;
        int d = this.getDegree();
        if(d != obj1.getDegree()) return false;
        boolean b = true;
        for(int i = 0; i < d; ++i) {
            if(!Extra.isEqual(this.coeffs[i], obj1.coeffs[i])) {
                b = false;
                break;
            }
        }
        return b;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }

    public double evaluate(double x) {
        //Horner's rule
        int degree = getDegree();
        double sum = 0;
        while (degree > -1) {
            sum += coeffs[degree--];
            if(degree != -1) {
                sum *= x;
            }
        }
        return sum;
    }

    public MyPolynomial add(MyPolynomial right){
        MyPolynomial objMin, objMax;
        if(right != null) {
            if(this.getDegree() >= right.getDegree()) {
                objMin = right;
                objMax = this;
            } else {
                objMin = this;
                objMax = right;
            }
        } else {
            objMax = this;
            objMin = new MyPolynomial();
        }
        int nMin, nMax;
        nMin = objMin.getDegree() + 1;
        nMax = objMax.getDegree() + 1;
        double[] coeffsNew = new double[nMax];
        for (int i = 0; i < nMin; ++i) {
            coeffsNew[i] = objMin.coeffs[i] + objMax.coeffs[i];
        }
        for (int i = nMin; i < nMax; ++i) {
            coeffsNew[i] = objMax.coeffs[i];
        }
        return new MyPolynomial(coeffsNew);
    }

    //In this method we use the Fast Fourier Transform in order to have O(N*lnN) instead of O(N^2)
    public MyPolynomial multiply(MyPolynomial right) {
        if(right == null) {
            return new MyPolynomial(0);
        }
        int dThis = this.getDegree();
        int dRight = right.getDegree();
        int L = dThis + dRight + 1;
        int L1 = L;
        int temp1 = 2;
        while(true) {
            if(temp1 >= L) {
                L1 = temp1;
                break;
            }
            temp1 = temp1 << 1;
        }
        MyComplex[] complexDataThis = new MyComplex[L1];
        MyComplex[] complexDataRight = new MyComplex[L1];
        for(int i = 0; i < L1; ++i) {
            complexDataThis[i] = new MyComplex(((i <= dThis) ? this.coeffs[i] : 0), 0);
            complexDataRight[i] = new MyComplex(((i <= dRight) ? right.coeffs[i] : 0), 0);
        }
        MyComplex[] A = fastFourierTransform(complexDataThis,false);
        MyComplex[] B = fastFourierTransform(complexDataRight, false);
        MyComplex[] C = new MyComplex[L1];
        for(int i = 0; i < L1; ++i) {
            C[i] = A[i].multiplyNew(B[i]);
        }
        MyComplex[] complexDataResult = fastFourierTransform(C,true);
        for(int i = 0; i < L1; ++i) {
            complexDataResult[i].setValue(complexDataResult[i].getReal() / L1, complexDataResult[i].getImag() / L1);
        }
        double[] result = new double[L];
        for(int i = 0; i < L; ++i) {
            result[i] = Math.round(complexDataResult[i].getReal() * 100000.0) / 100000.0;
        }
        return new MyPolynomial(result);
    }

    private MyComplex[] fastFourierTransform(MyComplex[] x, boolean isInverse) {
        int L = x.length;
        //The end of the recursion
        if (L == 1){
            return x;
        }
        //Creating two arrays with data (even and odd indexes)
        int L1 = L / 2;
        MyComplex[] xEven = new MyComplex[L1];
        MyComplex[] xOdd = new MyComplex[L1];
        for (int i = 0; i < L1; ++i) {
            int tmp1 = 2 * i;
            xEven[i] = new MyComplex(x[tmp1].getReal(), x[tmp1].getImag());
            xOdd[i] = new MyComplex(x[tmp1 + 1].getReal(), x[tmp1 + 1].getImag());
        }
        //Creating two spectrum-arrays and starting the recursion
        MyComplex[] sEven = fastFourierTransform(xEven, isInverse);
        MyComplex[] sOdd = fastFourierTransform(xOdd, isInverse);
        //Counting wn and w
        MyComplex w = new MyComplex(1,0);
        double tmp2 = -(2 * Math.PI / L) * (isInverse ? (-1) : 1);
        MyComplex wn = new MyComplex(Math.cos(tmp2), Math.sin(tmp2));
        MyComplex tmp3;
        for(int i = 0; i < L1; ++i) {
            tmp3 = w.multiplyNew(sOdd[i]);
            x[i] = sEven[i].addNew(tmp3);
            x[i + L1] = sEven[i].subtractNew(tmp3);
            w.multiply(wn);
        }
        return x;
    }

    //In this method we use O(N^2)
    public MyPolynomial multiply2(MyPolynomial right) {
        if(right == null) {
            return new MyPolynomial(0);
        }
        int dThis = this.getDegree();
        int dRight = right.getDegree();
        int L = dThis + dRight + 1;
        double[] result = new double[L];
        for(int i = 0; i < L; ++i) { result[i] = 0; }
        for(int i = 0; i <= dThis; ++i) {
            for(int j = 0; j <= dRight; ++j) {
                result[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(result);
    }

}