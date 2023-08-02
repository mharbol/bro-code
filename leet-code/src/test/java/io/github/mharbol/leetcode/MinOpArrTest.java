
package io.github.mharbol.leetcode;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * MinOpArrTest
 */
public class MinOpArrTest {

    private static MinOpArr cut;

    @BeforeClass
    public static void setupClass() {
        cut = new MinOpArr();
    }

    @Test
    public void testCase1() {
        Assert.assertEquals(cut.minOperations(1), 0);
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(cut.minOperations(2), 1);
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(cut.minOperations(3), 2);
    }

    @Test
    public void testCase4() {
        Assert.assertEquals(cut.minOperations(4), 4);
    }

    @Test
    public void testCase5() {
        Assert.assertEquals(cut.minOperations(5), 6);
    }

    @Test
    public void testCase6() {
        Assert.assertEquals(cut.minOperations(6), 9);
    }

    @Test
    public void testCase7() {
        Assert.assertEquals(cut.minOperations(7), 12);
    }
}
