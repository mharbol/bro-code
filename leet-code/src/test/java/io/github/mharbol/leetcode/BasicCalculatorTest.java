
package io.github.mharbol.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * BasicCalculatorTest
 *
 * Test class for BasicCalculator.
 */
public class BasicCalculatorTest {

    private BasicCalculator cut;
    private int expected = 0;
    private int actual = 0;
    private String input;

    @Before
    public void setup() {
        cut = new BasicCalculator();
    }

    @Test
    public void testLeetCode1() {
        input = "1 + 1";
        actual = cut.calculate(input);
        expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode2() {
        input = " 2-1 + 2 ";
        actual = cut.calculate(input);
        expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode3() {
        input = "(1+(4+5+2)-3)+(6+8)";
        actual = cut.calculate(input);
        expected = 23;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode4() {
        input = "2147483647";
        actual = cut.calculate(input);
        expected = 2147483647;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode5() {
        input = "-(-2)+4";
        actual = cut.calculate(input);
        expected = 6;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode6() {
        input = "5+3-4-(1+2-7+(10-1+3+5+(3-0+(8-(3+" +
            "(8-(10-(6-10-8-7+(0+0+7)-10+5-3-2+(9+0+" +
            "(7+(2-(2-(9)-2+5+4+2+(2+9+1+5+5-8-9-2-9" +
            "+1+0)-(5-(9)-(0-(7+9)+(10+(6-4+6))+0-2+" +
            "(10+7+(8+(7-(8-(3)+(2)+(10-6+10-(2)-7-(" +
            "2)+(3+(8))+(1-3-8)+6-(4+1)+(6))+6-(1)-(" +
            "10+(4)+(8)+(5+(0))+(3-(6))-(9)-(4)+(2))" +
            "))))-1)))+(9+6)+(0))))+3-(1))+(7))))))))";
        actual = cut.calculate(input);
        expected = -35;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegativeNegative() {
        input = "-(-2)";
        actual = cut.calculate(input);
        expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParseDigit() {
        input = "2";
        expected = 2;
        actual = cut.parseNumber(input, input.length());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParseDigitOffset() {
        input = "2 + 3";
        actual = cut.parseNumber(input, input.length());
        Assert.assertEquals(2, actual, input.length());
        cut = new BasicCalculator(4);
        actual = cut.parseNumber(input, input.length());
        Assert.assertEquals(3, actual);
    }

    @Test
    public void testSimpleNegation() {
        input = "-1 + 3";
        expected = 2;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBiggerNegation() {
        input = "-(1 + 3)";
        expected = -4;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNestedParens() {
        input = "((((((9))))))";
        expected = 9;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMidwayZero() {
        input = "(3 + 2 - 5 - 4-1)";
        expected = -5;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMidwayZeroCalc() {
        input = "12 + (3 + 2 - 5 - 4-1) - 3";
        expected = 4;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testMultiNegation() {
        input = "-(-(-(((-(49))))))";
        expected = 49;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHugeEquation() {
        input = "2 + (23 + 4 - 43 -(12 -3 -(3 + 7 +(-5)) - 4))";
        expected = -14;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGigantic() {
        input = "684 - 44 + 22 -(234 + (3) -(-3+4-(-(4))) - 43 + 43 -(33 -4 + (373 - 43 )+ (234 - 245 +   (22 - 4))))";
        expected = 796;
        actual = cut.calculate(input);
        Assert.assertEquals(expected, actual);
    }
}
