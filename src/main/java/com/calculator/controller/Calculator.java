package com.calculator.controller;

import java.util.HashMap;
import java.util.Map;

import com.calculator.operations.Operation;
import com.calculator.operations.OperationStrategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Calculator {
    private Map<Operation, OperationStrategy> operations = new HashMap<>();

    public OperationStrategy registerOperation(Operation op, OperationStrategy strategy) {
        return operations.put(op, strategy);
    }

    /**
     * Return the result of the calculation based on the operation
     * @param operation an enum, currently support ADD, SUBTRACT,
     * MULTIPLY, DIVIDE
     * @param n1 number in double value
     * @param n2 number in double value
     * @return the result
     */
    public double calculate(final Operation operation, final double n1, final double n2) {
        if (operation == null || !operations.containsKey(operation)) {
            throw new UnsupportedOperationException("Operation not supported in the Calculator.");
        }
        return operations.get(operation).calculate(n1, n2);
    }

    public double chainOperations(final double initial, final Operation[] ops, final double[] n) {
        if (ops == null || n == null) {
            throw new IllegalArgumentException("The input cannot be null.");
        }
        if (ops.length != n.length) {
            throw new IllegalArgumentException("Operations and numbers length mismatch.");
        }

        double res = initial;
        for (int i = 0; i < ops.length; i++) {
            res = calculate(ops[i], res, n[i]);
        }
        return res;
    }
}
