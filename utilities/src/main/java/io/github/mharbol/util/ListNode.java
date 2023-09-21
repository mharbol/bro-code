
package io.github.mharbol.util;

/**
 * Leetcode definition for singly-linked list (with a little extra).
 */
public class ListNode {

    /**
     * The value contained by this node
     */
    public int val;

    /**
     * The next node in this linked list
     */
    public ListNode next;

    /**
     * Default constructor; initializes an empty linked list holding a default
     * value.
     */
    public ListNode() {
    }

    /**
     * Initiates a {@link ListNode} with no child node
     * 
     * @param val the value of this node
     */
    public ListNode(int val) {
        this.val = val;
    }

    /**
     * Initiates a {@link ListNode} with a child node
     * 
     * @param val  the value of this node
     * @param next the next node in this list
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Get the value of this node
     * 
     * @return the value contained by this node
     */
    public int getVal() {
        return this.val;
    }

    /**
     * Get the next value in this linked list.
     * 
     * @return the next {@link ListNode} in this linked list, {@code null} indicates
     *         no more
     */
    public ListNode getNext() {
        return this.next;
    }

    /**
     * Check for equality.
     * 
     * @return true if the two objects are considered equivalent otherwise false.
     */
    @Override
    public boolean equals(Object other) {

        // check equality on the nodes
        if (other == null) {
            return false;
        }

        if (!(other instanceof ListNode)) {
            return false;
        }

        if (this.val != ((ListNode) other).val) {
            return false;
        }

        // by the time we are here, both objects are ListNodes and hold the same value
        // check (recursively, potentially) that the next values are also the same
        ListNode thisNext = this.next;
        ListNode otherNext = ((ListNode) other).next;

        if (thisNext == null && otherNext == null) {
            return true;
        }

        if (thisNext == null && otherNext != null) {
            return false;
        }

        return thisNext.equals(otherNext);
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }

    /**
     * Creates a new ListNode from the input values.
     *
     * @param values the ordered values to enter into the ListNode
     * @return the head of a ListNode representation of values; `null` if the list is empty.
     */
    public static ListNode newList(int... values) {

        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode curr = head;

        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }

        return head;
    }
}
