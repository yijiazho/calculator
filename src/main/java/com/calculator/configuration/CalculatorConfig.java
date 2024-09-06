package com.calculator.configuration;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.calculator.controller.Calculator;
import com.calculator.operations.Addition;
import com.calculator.operations.Division;
import com.calculator.operations.Multiplication;
import com.calculator.operations.Operation;
import com.calculator.operations.OperationStrategy;
import com.calculator.operations.Subtraction;

@Configuration
public class CalculatorConfig {
    @Bean
    public Calculator calculator() {
        Map<Operation, OperationStrategy> defaultOperations = Map.of(
                    Operation.ADD, new Addition(),
                    Operation.SUBTRACT, new Subtraction(),
                    Operation.MULTIPLY, new Multiplication(),
                    Operation.DIVIDE, new Division()
            );
        return new Calculator(defaultOperations);
    }
}
