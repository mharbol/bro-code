
package io.github.mharbol.leetcode;

/**
 * ShiftArray
 *
 * Wrapper class for LeetCode problem 189
 */
public class ShiftArray {

    /**
     * Rotates an array to the right by a specified interval
     *
     * @param nums array to be rotated
     * @param k    the (positive) count to shift the array by
     */
    public void rotateWithSecondArray(int[] nums, int k) {

        final int len = nums.length;

        int[] temp = new int[len];

        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }
}
