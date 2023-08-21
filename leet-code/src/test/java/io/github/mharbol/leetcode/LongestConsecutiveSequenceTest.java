
package io.github.mharbol.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * LongestConsecutiveSequenceTest
 */
public class LongestConsecutiveSequenceTest {

    private LongestConsecutiveSequence cut;
    private int[] nums;
    private int expected;
    private int actual;

    @Before
    public void setup() {
        cut = new LongestConsecutiveSequence();
    }

    @Test
    public void testLeetCode1() {
        nums = new int[] { 100, 4, 200, 1, 3, 2 };
        expected = 4;
        actual = cut.longestConsecutiveNeet(nums);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode2() {
        nums = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        expected = 9;
        actual = cut.longestConsecutiveNeet(nums);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode1Frank() {
        nums = new int[] { 100, 4, 200, 1, 3, 2 };
        expected = 4;
        actual = cut.longestConsecutive(nums);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode2Frank() {
        nums = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        expected = 9;
        actual = cut.longestConsecutive(nums);
        Assert.assertEquals(expected, actual);
    }
}
