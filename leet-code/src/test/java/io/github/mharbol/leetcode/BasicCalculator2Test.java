
package io.github.mharbol.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * BasicCalculatorTest
 *
 * Test class for BasicCalculator.
 */
public class BasicCalculator2Test {

    private BasicCalculator2 cut;
    private int expected = 0;
    private int actual = 0;
    private String input;

    @Before
    public void setup() {
        cut = new BasicCalculator2();
    }

    @Test
    public void testLeetCode1() {
        input = "3+2*2";
        expected = 7;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode2() {
        input = " 3/2 ";
        expected = 1;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode3() {
        input = " 3+5 / 2";
        expected = 5;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }
}
