
package io.github.mharbol.leetcode.jumpgame;

/**
 * JumpGame1
 * Wrapper class for LeetCode 55
 */
public class JumpGame1 {

    /**
     * Determines if one can jump to the end position of the array from the start.
     *
     * @param nums the jump lengths by position
     * @return true if reaching the end is possible otherwise false
     */
    public boolean canJump(int[] nums) {

        // easy exit cases
        if (nums.length <= 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }

        // represents the location of the next [potential] zero
        int zeroPointer = nums.length - 2;

        // the current position we are checking
        int currPos;

        // loop until we are at the last position
        while (zeroPointer > 0) {
            // progress zero pointer
            if (nums[zeroPointer] != 0) {
                zeroPointer--;
                continue;
            }
            // walk the current position back to a point that can jump this zero
            // then set that as the new zero pointer
            currPos = zeroPointer - 1;
            while (currPos >= 0) {
                if (nums[currPos] + currPos > zeroPointer) {
                    zeroPointer = currPos;
                    break;
                } else {
                    currPos--;
                }
            }
            // if the currPos walks all the way to the end, then we cannot jump this
            if (currPos == -1) {
                return false;
            }
            zeroPointer--;
        }
        // if the pointer makes it to the end, then we can jump through the whole thing
        return true;
    }
}
