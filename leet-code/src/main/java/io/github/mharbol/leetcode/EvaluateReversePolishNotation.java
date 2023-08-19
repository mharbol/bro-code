
package io.github.mharbol.leetcode;

import java.util.Stack;

/**
 * EvaluateReversePolishNotation
 *
 * Wrapper class for LeetCode problem 150
 */
public class EvaluateReversePolishNotation {

    /**
     * Evaluates an expression represented in Reverse Polish Notation (RPN).
     *
     * @param tokens the RPN represnetation of the expression containing integers,
     *               +, -, *. and /
     * @return the result of the calculation
     */
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int left, right;

        for (String token : tokens) {

            switch (token) {

                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left + right);
                    break;

                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;

                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left * right);
                    break;

                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left / right);
                    break;

                default: // the input is a number
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
