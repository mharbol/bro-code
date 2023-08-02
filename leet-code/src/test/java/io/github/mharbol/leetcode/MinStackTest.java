
package io.github.mharbol.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * MinStackTest
 */
public class MinStackTest {

    private MinStack minStack;

    @Before
    public void before() {
        minStack = new MinStack();
    }

    /**
     * Tests the LeetCode example
     */
    @Test
    public void testLeetCode() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertTrue(minStack.getMin() == -3);
        minStack.pop();
        assertTrue(minStack.top() == 0);
        assertTrue(minStack.getMin() == -2);
    }

    /**
     * Tests the basic functionality of the MinStack
     */
    @Test
    public void testBaisic() {
        assertTrue(minStack.size() == 0);
        minStack.push(12);
        assertTrue(minStack.size() == 1);
        assertTrue(minStack.top() == 12);
        assertTrue(minStack.getMin() == 12);
        minStack.pop();
        assertTrue(minStack.size() == 0);
    }

    /**
     * Tests that MinStack works when the minimum value is pushed first
     */
    @Test
    public void testMinFirst() {
        minStack.push(-1);
        minStack.push(5);
        minStack.push(3);
        assertTrue(minStack.getMin() == -1);
    }

    /**
     * Tests that MinStack works when the minimum value is pushed last
     */
    @Test
    public void testMinLast() {
        minStack.push(5);
        minStack.push(3);
        minStack.push(-1);
        assertTrue(minStack.getMin() == -1);
    }

    /**
     * Tests that MinStack works when the minimum value is pushed in the middle
     */
    @Test
    public void testMinMid() {
        minStack.push(5);
        minStack.push(-1);
        minStack.push(3);
        assertTrue(minStack.getMin() == -1);
    }

    /**
     * Tests that MinStack works when the minimum value is pushed twice
     */
    @Test
    public void testMinTwice() {
        minStack.push(34);
        minStack.push(-1);
        minStack.push(5);
        minStack.push(-1);
        minStack.push(3);
        assertTrue(minStack.getMin() == -1);
        minStack.pop(); // head == -1, min == -1
        assertTrue(minStack.getMin() == -1);
        assertTrue(minStack.top() == -1);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        assertTrue(minStack.getMin() == 34);
        assertTrue(minStack.top() == 34);
        minStack.pop();
        assertTrue(minStack.size() == 0);
    } 
}
