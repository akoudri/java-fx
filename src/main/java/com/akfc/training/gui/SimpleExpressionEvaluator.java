package com.akfc.training.gui;

import java.util.Stack;

/**
 * Simple expression evaluator for basic arithmetic operations.
 * Supports: +, -, *, /, parentheses, and decimal numbers.
 * This implementation uses the Shunting Yard algorithm for parsing
 * and evaluation without external dependencies.
 */
public class SimpleExpressionEvaluator {
    
    /**
     * Evaluates a mathematical expression string
     * @param expression The expression to evaluate (e.g., "2+3*4")
     * @return The result of the evaluation
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static double evaluate(String expression) throws IllegalArgumentException {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty");
        }
        
        // Remove spaces
        expression = expression.replaceAll("\\s+", "");
        
        // Convert infix to postfix using Shunting Yard algorithm
        String postfix = infixToPostfix(expression);
        
        // Evaluate postfix expression
        return evaluatePostfix(postfix);
    }
    
    /**
     * Converts infix expression to postfix using Shunting Yard algorithm
     */
    private static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            // If character is a digit or decimal point, add it to result
            if (Character.isDigit(c) || c == '.') {
                // Read the complete number
                StringBuilder number = new StringBuilder();
                while (i < infix.length() && (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    number.append(infix.charAt(i));
                    i++;
                }
                i--; // Adjust for the extra increment in the loop
                result.append(number).append(" ");
            }
            // If character is '(', push it to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If character is ')', pop and add to result until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove '('
                }
            }
            // If character is an operator
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        
        // Pop all remaining operators from stack
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        
        return result.toString().trim();
    }
    
    /**
     * Evaluates a postfix expression
     */
    private static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");
        
        for (String token : tokens) {
            if (token.isEmpty()) continue;
            
            if (isOperator(token.charAt(0)) && token.length() == 1) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = performOperation(a, b, token.charAt(0));
                stack.push(result);
            } else {
                try {
                    stack.push(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid number: " + token);
                }
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        
        return stack.pop();
    }
    
    /**
     * Performs arithmetic operation
     */
    private static double performOperation(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
    
    /**
     * Checks if character is an operator
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    /**
     * Returns precedence of operators
     */
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}