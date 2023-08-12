
package io.github.mharbol.leetcode;

/**
 * BasicCalculator
 * Wrapper class for LeetCode 224 BasicCalculator
 */
public class BasicCalculator {

    /**
     * The index of the character currently parsing
     */
    private int index = 0;

    /**
     * Default constructor
     */
    public BasicCalculator() {
    }

    /**
     * Initilize a {@link BasicCalculator} with non-default index.
     * 
     * @param index the index to start at
     */
    public BasicCalculator(int index) {
        this.index = index;
    }

    /**
     * Performs a basic addition/substraction operation based on a given input
     * string.
     * 
     * @param string representation of a simple, VALID, expression
     * @return the result of evaluating the expression
     */
    public int calculate(String string) {

        int accumulator = 0;
        final int length = string.length();

        while (index < length) {

            switch (string.charAt(index)) {

                case ' ':
                    progressIndex(string, length);
                    break;

                case '+':
                    progressIndex(string, length);
                    if (Character.isDigit(string.charAt(index))) {
                        accumulator += parseNumber(string, length);
                    }
                    // in this case, the next character has to be an open pren
                    else {
                        progressIndex(string, length);
                        accumulator += calculate(string);
                    }
                    break;

                case '-':
                    progressIndex(string, length);
                    if (Character.isDigit(string.charAt(index))) {
                        accumulator -= parseNumber(string, length);
                    }
                    // in this case, the next character has to be an open pren
                    else {
                        progressIndex(string, length);
                        accumulator -= calculate(string);
                    }
                    break;

                case '(':
                    progressIndex(string, length);
                    accumulator += calculate(string);
                    break;

                case ')':
                    progressIndex(string, length);
                    return accumulator;

                default: // the character must be a digit at this point
                    accumulator += parseNumber(string, length);
                    break;
            }
        }

        return accumulator;
    }

    /**
     * Parses the next character which must be a digit/number and progresses the
     * index to the next place.
     *
     * @param string the string to parse
     * @return the integer representation of the number or digit
     */
    protected int parseNumber(String string, final int length) {
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
