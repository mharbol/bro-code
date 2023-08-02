
package io.github.mharbol.leetcode;

import io.github.mharbol.util.ListNode;

/**
 * EndOfLinkedList
 * Wrapper class for LeetCode 19
 */
public class EndOfLinkedList {

    /**
     * Removes the nth node from the end of a linked list
     *
     * @param head the head of the input {@link ListNode}
     * @param n    the index of the element off the tail of the linked list to
     *             remove
     * @return the linked list without the nth element from the end
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int currentLength = 0;
        ListNode drop = head;
        ListNode prev = null;
        ListNode curr = head;

        // work to the end of the linked list
        while (curr != null) {
            currentLength++;
            if (currentLength > n) {
                prev = drop;
                drop = drop.next;
            }
            curr = curr.next;
        }

        // if n is the same as the size, then "removing" the first item is just
        // returning the second node onward
        if (currentLength == n) {
            return head.next;
        }

        // otherwise drop the remove node and return head
        prev.next = drop.next;
        return head;
    }
}
