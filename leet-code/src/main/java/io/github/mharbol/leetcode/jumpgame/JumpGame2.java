
package io.github.mharbol.leetcode.jumpgame;

/**
 * JumpGame2
 */
public class JumpGame2 {

    /**
     * Computes the minimum number of jumps to get to the end.
     *
     * @param nums array to jump through
     * @return the minimum number of jumps to make it to the end
     */
    public int jump(int[] nums) {

        int numjumps = 0;

        final int len = nums.length;

        if (len <= 1) {
            return 0;
        }

        int currentIndex = len - 1;
        int nextPoint;

        while (currentIndex > 0) {
            nextPoint = 0;
            while (nextPoint < currentIndex) {
                if (nums[nextPoint] + nextPoint >= currentIndex) {
                    currentIndex = nextPoint;
                    numjumps++;
                    break;
                }
                nextPoint++;
            }
        }
        return numjumps;
    }
}
