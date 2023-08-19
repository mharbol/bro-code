
package io.github.mharbol.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * EvaluateReversePolishNotationTest
 */
public class EvaluateReversePolishNotationTest {

    private EvaluateReversePolishNotation cut;
    private String[] tokens;
    private int expected;
    private int actual;

    @Before
    public void setup() {
        cut = new EvaluateReversePolishNotation();
    }

    @Test
    public void testLeetCode1() {
        tokens = new String[] { "2", "1", "+", "3", "*" };
        expected = 9;
        actual = cut.evalRPN(tokens);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode2() {
        tokens = new String[] { "4", "13", "5", "/", "+" };
        expected = 6;
        actual = cut.evalRPN(tokens);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode3() {
        tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        expected = 22;
        actual = cut.evalRPN(tokens);
        Assert.assertEquals(expected, actual);
    }
}
