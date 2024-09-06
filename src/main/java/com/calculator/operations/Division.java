package com.calculator.operations;

public class Division implements OperationStrategy {
    private static final double PERCISION = 1e-9;
    
    @Override
    public double calculate(final double x, final double y) {
        if (Math.abs(y) < PERCISION) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return x / y;
    }

}
