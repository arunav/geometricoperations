package org.example.pojo;

public class Line {

    int a;
    int b;
    int intercept;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getIntercept() {
        return intercept;
    }

    public void setIntercept(int intercept) {
        this.intercept = intercept;
    }

    @Override
    public String toString() {
        return new StringBuilder().
                append(a)
                .append("X+")
                .append(b)
                .append("Y =")
                .append(intercept).toString();
    }
}
