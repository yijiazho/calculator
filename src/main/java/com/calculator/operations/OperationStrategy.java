package com.calculator.operations;

public interface OperationStrategy {
    /**
     * return the result of the defined operation strategy
     * applying to two given double precision numbers in order.
     * the result might overflow to Infinity or -Inifinity
     * @param x from -Double.MAX_VALUE to Double.MAX_VALUE
     * @param y from -Double.MAX_VALUE to Double.MAX_VALUE
     * @return the result of the operation
     */
    double calculate(final double x, final double y);
}
