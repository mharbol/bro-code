
package io.github.mharbol.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * HappyNumbersTest
 */
public class HappyNumbersTest {

    private HappyNumbers cut;

    @Before
    public void setup() {
        cut = new HappyNumbers();
    }

    @Test
    public void testLeet1() {
        Assert.assertTrue(cut.isHappy(19));
    }

    @Test
    public void testLeet2() {
        Assert.assertFalse(cut.isHappy(2));
    }

    @Test
    public void testDemo() {
        Assert.assertFalse(cut.isHappy(11));
    }
}
