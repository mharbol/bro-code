
package io.github.mharbol.leetcode;

import java.util.Stack;

/**
 * BasicCalculator2
 *
 * Wrapper class for LeetCode problem 227
 */
public class BasicCalculator2 {

    private int index = 0;

    /**
     * Calculates the given input with addition, subtraction, multiplication, and
     * integer division
     *
     * @param string the string holding the calculation
     * @return the value after evaluating the expression
     */
    public int calculate(String string) {

        // in the first problem, we could count on the next operation taking equal
        // precidence, now we can't
        //
        // consider the whole calculation a summation and push the reults of anything
        // else (multiplication and division)

        final int length = string.length();

        Stack<Integer> calcStack = new Stack<>();

        while (index < length) {
            switch (string.charAt(index)) {
                case ' ':
                    progressIndex(string, length);
                    break;
                case '+':
                    progressIndex(string, length);
                    calcStack.push(parseNumber(string, length));
                    break;
                case '-':
                    progressIndex(string, length);
                    calcStack.push(-parseNumber(string, length));
                    break;
                case '*':
                    progressIndex(string, length);
                    calcStack.push(calcStack.pop() * parseNumber(string, length));
                    break;
                case '/':
                    progressIndex(string, length);
                    calcStack.push(calcStack.pop() / parseNumber(string, length));
                    break;
                default:
                    calcStack.push(parseNumber(string, length));
                    break;
            }
        }

        int retVal = 0;
        while (!calcStack.isEmpty()) {
            retVal += calcStack.pop();
        }
        return retVal;
    }

    /**
     * Parses the next character which must be a digit/number and progresses the
     * index to the next place.
     *
     * @param string the string to parse
     * @return the integer representation of the number or digit
     */
    protected final int parseNumber(String string, final int length) {
        int retVal = 0;

        while (index < length && Character.isDigit(string.charAt(index))) {
            retVal = retVal * 10 + (int) (string.charAt(index) - '0');
            index++;
        }
        return retVal;
    }

    /**
     * Progress the index to the next non-space character
     *
     * @param string the string holding the math expressing
     * @param length the length of the input string
     */
    private void progressIndex(String string, final int length) {
        do {
            index++;
        } while (index < length && string.charAt(index) == ' ');
    }
}
