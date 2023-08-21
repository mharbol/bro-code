
package io.github.mharbol.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * LongestConsecutiveSequence
 */
public class LongestConsecutiveSequence {

    /**
     * Finds the length of the longest consecutive sequence.
     * This was NeetCode's solution.
     *
     * @param nums the unordered list of numbers
     * @return the length of the longest consecutive sequence
     */
    public int longestConsecutiveNeet(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        int longest = 0;
        int length;
        for (int num : nums) {
            numSet.add(num);
        }

        for (int n : nums) {
            // check for start of sequence
            if (!numSet.contains(n - 1)) {
                length = 0;
                // grow the length as we grow more numbers
                while (numSet.contains(n + length)) {
                    length++;
                }
                // update longest if needed
                if (length > longest)
                    longest = length;
            }
        }
        return longest;
    }

    /**
     * Finds the length of the longest consecutive sequence.
     * This was Frank's solution.
     *
     * @param nums the unordered list of numbers
     * @return the length of the longest consecutive sequence
     */
    public int longestConsecutive(int[] nums) {

        // add the numbers to the set
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        int length;

        for (int number : nums) {

            if (numSet.contains(number)) {

                length = 1;

                // get the next number
                numSet.remove(number);

                // first walk right
                for (int i = number + 1; numSet.contains(i); i++) {
                    length++;
                    numSet.remove(i);
                }

                // then walk left
                for (int i = number - 1; numSet.contains(i); i--) {
                    length++;
                    numSet.remove(i);
                }

                // update longest as needed
                if (length > longest)
                    longest = length;
            }
        }
        return longest;
    }
}
