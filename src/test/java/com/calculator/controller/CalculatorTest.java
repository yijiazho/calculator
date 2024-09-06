package com.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculator.configuration.CalculatorConfig;
import com.calculator.operations.Operation;

@SpringBootTest(classes = CalculatorConfig.class)
public class CalculatorTest {
    @Autowired
    private Calculator calculator;
    
    @Test
    public void testAddition() {
        assertEquals(5.0, calculator.calculate(Operation.ADD, 2.0, 3.0));
    }

    @Test
    public void testAdditionNegative() {
        assertEquals(-8.5, calculator.calculate(Operation.ADD, -5.5, -3.0));
    }

    @Test
    public void testAdditionOverflow() {
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(Operation.ADD, Double.MAX_VALUE, Double.MAX_VALUE));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1.0, calculator.calculate(Operation.SUBTRACT, 5.0, 4.0));
    }

    @Test
    public void testSubtractionNegative() {
        assertEquals(9.0, calculator.calculate(Operation.SUBTRACT, 5.0, -4.0));
    }

    @Test
    public void testMultiplication() {
        assertEquals(10.0, calculator.calculate(Operation.MULTIPLY, 2.0, 5.0));
    }

    @Test
    public void testMultiplicationNegative() {
        assertEquals(-10.0, calculator.calculate(Operation.MULTIPLY, -2.0, 5.0));
    }

    @Test
    public void testDivision() {
        assertEquals(0.5, calculator.calculate(Operation.DIVIDE, 5.0, 10.0));
    }

    @Test
    public void testDivisionNegative() {
        assertEquals(-0.5, calculator.calculate(Operation.DIVIDE, -5.0, 10.0));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 10.0, 0.0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testUnsupportedOperation() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(null, 10.0, 2.0);
        });
        assertEquals("Operation not supported in the Calculator.", exception.getMessage());
    }


    @Test
    public void testChainedOperationsWithNullInput() {
        Operation[] ops = {Operation.ADD, Operation.MULTIPLY, Operation.SUBTRACT};
        double[] nums = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.chainOperations(0.0, ops, nums);
        });
        assertEquals("The input cannot be null.", exception.getMessage());
    }

    @Test
    public void testChainedOperationsMismatch() {
        Operation[] ops = {Operation.ADD, Operation.MULTIPLY, Operation.SUBTRACT};
        double[] nums = {5.0, 2.0, 3.5, -6.5};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.chainOperations(0.0, ops, nums);
        });
        assertEquals("Operations and numbers length mismatch.", exception.getMessage());
    }

    @Test
    public void testChainedOperations() {
        Operation[] ops = {Operation.ADD, Operation.MULTIPLY, Operation.SUBTRACT};
        double[] nums = {5.0, 2.0, -3.5};
        assertEquals(21.5, calculator.chainOperations(4.0, ops, nums));
    }
}

