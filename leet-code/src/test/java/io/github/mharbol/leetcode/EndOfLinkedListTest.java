
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
        ListNode node1 = ListNode.newList(1, 2, 3, 4, 5);

        ListNode expected = ListNode.newList(1, 2, 3, 5);

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

        ListNode node1 = ListNode.newList(1,2);

        ListNode expected = new ListNode(1);

        ListNode actual = cut.removeNthFromEnd(node1, 1);

        Assert.assertEquals(expected, actual);
    }

}
