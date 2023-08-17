
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

    /**
     * Rotates an array to the right by a specified interval with constant space.
     * This comes at the cost of a much longer practical runtime.
     *
     * @param nums array to be rotated
     * @param k    the (positive) count to shift the array by
     */
    public void rotateWithShifts(int[] nums, int k) {

        k %= nums.length;

        for (int i = 0; i < k; i++) {
            rotateArrayByOne(nums);
        }
    }

    /**
     * Reverses a slice of the array in the range [left, right]
     *
     * @param nums  the array to reverse a subset of elements
     * @param left  the start of the reverse
     * @param right the end of the reverse (inclusive)
     */
    private void reverse(int[] nums, int left, int right) {
        int temp;
        for (; left < right; left++, right--) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    /**
     * Rotates an array to the right by a specified interval with constant space.
     * First reverses the array, then reverses the left and right chunks
     *
     * @param nums array to be rotated
     * @param k    the (positive) count to shift the array by
     */
    public void rotateArrayTripleReverse(int[] nums, int k) {
        final int len = nums.length;
        if (len <= 1)
            return;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
}
