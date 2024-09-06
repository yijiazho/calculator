package com.calculator.operations;

public class Addition implements OperationStrategy {

    @Override
    public double calculate(final double x, final double y) {
        return x + y;
    }

}
