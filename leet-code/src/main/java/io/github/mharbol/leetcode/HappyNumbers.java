
package io.github.mharbol.leetcode;

/**
 * HappyNumbers
 *
 * Wrapper class for Leet Code 202
 */

public class HappyNumbers {

    /**
     * Determines if a number is "happy" or not.
     * 
     * @param n the base 10 number to assess happiness of
     * @return true if n is happy otherwise false
     */
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0 || n == 4) {
            return false;
        }
        return isHappy(happyFunc(n));
    }

    /**
     * Computes the happy function on the given base-10 integer.
     * 
     * @param n the base-10 input
     * @return the happy function as applied to {@code n}
     */
    private int happyFunc(int n) {
        int out = 0;
        int d;
        while (n > 0) {
            d = n % 10;
            n /= 10;
            out += d * d;
        }
        return out;
    }
}
