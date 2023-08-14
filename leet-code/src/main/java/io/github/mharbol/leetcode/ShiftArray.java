
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

    /**
     * Rotates the array one to the right
     *
     * @param nums the array to be rotated
     */
    protected void rotateArrayByOne(int[] nums) {

        final int len = nums.length;

        if (len <= 1)
            return;

        int last = nums[len - 1];

        for (int i = len - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
    }

    public void rotateWithShifts(int[] nums, int k) {

        k %= nums.length;

        for (int i = 0; i < k; i++) {
            rotateArrayByOne(nums);
        }
    }
}
