package javatest;

public class Calculator {
    public int multiply(int x, int y) {
        return x * y;
    }

    public float divide(int x, int y) {
        if (y == 0) 
            throw new IllegalArgumentException("Divided by zero: input y");
        return (float)x / (float)y;
    }
    
    public int add(int x, int y) {
        return x + y;
    }
}
