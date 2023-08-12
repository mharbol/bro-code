
package io.github.mharbol.leetcode;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ShiftArrayTest
 *
 * Test class for ShiftArray.
 */
public class ShiftArrayTest {

    private int[] nums, expected;
    private int k;
    private ShiftArray cut;

    @Before
    public void setup() {
        cut = new ShiftArray();
    }

    @Test
    public void testLeetCode1() {
        nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        k = 3;

        expected = new int[] { 5, 6, 7, 1, 2, 3, 4 };
        cut.rotateWithSecondArray(nums, k);
        Assert.assertTrue(Arrays.equals(expected, nums));
    }

    @Test
    public void testLeetCode2() {
        nums = new int[] { -1, -100, 3, 99 };
        k = 2;

        expected = new int[] { 3, 99, -1, -100 };
        cut.rotateWithSecondArray(nums, k);
        Assert.assertTrue(Arrays.equals(expected, nums));
    }
}
