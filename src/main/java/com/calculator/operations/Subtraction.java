package com.calculator.operations;

public class Subtraction implements OperationStrategy {
    
    @Override
    public double calculate(final double x, final double y) {
        return x - y;
    }

}
