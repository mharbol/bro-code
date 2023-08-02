
package io.github.mharbol.leetcode;

/**
 * MinOpArr
 */
public class MinOpArr {

    public int minOperations(int n) {

        int half = n / 2;

        // if n is even, use the sum of the first [half] odds
        // sum of the first n odds is n * n
        if (n % 2 == 0) {
            return half * half;
        }

        // otherwise, use the sum of the first [half] evens
        // sum of the first n evens is n * (n + 1) 
        return half * (half + 1);
    }
}
