
package io.github.mharbol.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * MinStackTest
 */
public class MinStackTest {

    private MinStack cut;

    @Before
    public void before() {
        cut = new MinStack();
    }

    /**
     * Tests the LeetCode example
     */
    @Test
    public void testLeetCode() {
        cut.push(-2);
        cut.push(0);
        cut.push(-3);
        assertTrue(cut.getMin() == -3);
        cut.pop();
        assertTrue(cut.top() == 0);
        assertTrue(cut.getMin() == -2);
    }

    /**
     * Tests the basic functionality of the MinStack
     */
    @Test
    public void testBaisic() {
        assertTrue(cut.size() == 0);
        cut.push(12);
        assertTrue(cut.size() == 1);
        assertTrue(cut.top() == 12);
        assertTrue(cut.getMin() == 12);
        cut.pop();
        assertTrue(cut.size() == 0);
    }

    /**
     * Tests that MinStack works when the minimum value is pushed first
     */
    @Test
    public void testMinFirst() {
        cut.push(-1);
        cut.push(5);
        cut.push(3);
        assertTrue(cut.getMin() == -1);
    }

    /**
     * Tests that MinStack works when the minimum value is pushed last
     */
    @Test
    public void testMinLast() {
        cut.push(5);
        cut.push(3);
        cut.push(-1);
        assertTrue(cut.getMin() == -1);
    }

    /**
     * Tests that MinStack works when the minimum value is pushed in the middle
     */
    @Test
    public void testMinMid() {
        cut.push(5);
        cut.push(-1);
        cut.push(3);
        assertTrue(cut.getMin() == -1);
    }

    /**
     * Tests that MinStack works when the minimum value is pushed twice
     */
    @Test
    public void testMinTwice() {
        cut.push(34);
        cut.push(-1);
        cut.push(5);
        cut.push(-1);
        cut.push(3);
        assertTrue(cut.getMin() == -1);
        cut.pop(); // head == -1, min == -1
        assertTrue(cut.getMin() == -1);
        assertTrue(cut.top() == -1);
        cut.pop();
        cut.pop();
        cut.pop();
        assertTrue(cut.getMin() == 34);
        assertTrue(cut.top() == 34);
        cut.pop();
        assertTrue(cut.size() == 0);
    } 
}
