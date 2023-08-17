
package io.github.mharbol.leetcode.jumpgame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JumpGame2Test
 */
public class JumpGame2Test {

    private JumpGame2 cut;
    private int[] nums;

    @Before
    public void setup() {
        cut = new JumpGame2();
    }

    @Test
    public void testLeet1() {
        nums = new int[] { 2, 3, 1, 1, 4 };
        Assert.assertEquals(2, cut.jump(nums));
    }

    @Test
    public void testLeet2() {
        nums = new int[] { 2, 3, 0, 1, 4 };
        Assert.assertEquals(2, cut.jump(nums));
    }
}
