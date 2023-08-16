
package io.github.mharbol.leetcode.jumpgame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JumpGame1Test
 */
public class JumpGame1Test {

    private JumpGame1 cut;
    private int[] nums;

    @Before
    public void setup() {
        cut = new JumpGame1();
    }

    @Test
    public void testLeet1() {
        nums = new int[] { 2, 3, 1, 1, 4 };
        Assert.assertTrue(cut.canJump(nums));
    }

    @Test
    public void testLeet2() {
        nums = new int[] { 3, 2, 1, 0, 4 };
        Assert.assertFalse(cut.canJump(nums));
    }
}
