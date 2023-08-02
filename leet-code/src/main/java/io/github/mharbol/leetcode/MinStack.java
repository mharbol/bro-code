
package io.github.mharbol.leetcode;

import java.util.Stack;

/**
 * MinStack
 */
public class MinStack {

    /**
     * Default constructor for this MinStack. Creates an empty stack of {@code int}s that also can refer to the minimum value.
     */
    public MinStack() {}

    /**
     * The "traditional" stack that keeps track of the {@code int}s in order.
     */
    private Stack<Integer> tradStack = new Stack<>();

    /**
     * The minimum value stack that holds the value of the current minimum for this MinStack.
     */
    private Stack<Integer> minvStack = new Stack<>();

    /**
     * Push an {@code int} onto this MinStack.
     * @param val the value to be pushed onto this MinStack
     */
    public void push(int val) {

        // push the value to tradStack either way
        tradStack.push(val);

        // if this MinStack is empty or the minimum is greater than val, push val
        // this is cool because of short-circuiting
        if (minvStack.size() == 0 || getMin() > val) {
            minvStack.push(val);
        }
        else {
            minvStack.push(getMin());
        }
    }

    /**
     * Remove the head value of this MinStack.
     */
    public void pop() {
        tradStack.pop();
        minvStack.pop();
    }

    /**
     * Peek at the head value of this MinStack.
     * @return the head value of this MinStack
     */
    public int top() {
        return tradStack.peek();
    }

    /**
     * Peek at the minimum value of this MinStack.
     * @return the minimum value of this MinStack
     */
    public int getMin() {
        return minvStack.peek();
    }

    /**
     * Read the size of this MinStack.
     * @return the size of this MinStack as number of elements.
     */
    protected int size() {
        return tradStack.size();
    }
}
