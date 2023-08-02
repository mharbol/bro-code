
package io.github.mharbol.leetcode;

import org.junit.Assert;
import org.junit.Test;

import io.github.mharbol.util.ListNode;

/**
 * Test class for {@link EndOfLinkedList} class
 */
public class EndOfLinkedListTest {

    private EndOfLinkedList cut = new EndOfLinkedList();

    @Test
    public void testLeetCode1() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode expected5 = new ListNode(5);
        ListNode expected3 = new ListNode(3, expected5);
        ListNode expected2 = new ListNode(2, expected3);
        ListNode expected = new ListNode(1, expected2);

        ListNode actual = cut.removeNthFromEnd(node1, 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode2() {

        ListNode node = new ListNode(1);

        ListNode actual = cut.removeNthFromEnd(node, 1);

        Assert.assertNull(actual);
    }

    @Test
    public void testLeetCode3() {

        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);

        ListNode expected = new ListNode(1);

        ListNode actual = cut.removeNthFromEnd(node1, 1);

        Assert.assertEquals(expected, actual);
    }

}
