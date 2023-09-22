
package io.github.mharbol.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.github.mharbol.util.ListNode;

/**
 * MergeTwoSortedListsTest
 */
public class MergeTwoSortedListsTest {

    private MergeTwoSortedLists cut;
    private ListNode list1, list2, expected, actual;

    @Before
    public void setup() {
        cut = new MergeTwoSortedLists();
    }

    @Test
    public void testLeetCode1() {
        list1 = ListNode.newList(1, 2, 4);
        list2 = ListNode.newList(1, 3, 4);
        expected = ListNode.newList(1, 1, 2, 3, 4, 4);
        actual = cut.mergeTwoLists(list1, list2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLeetCode2() {
        list1 = null;
        list2 = null;
        actual = cut.mergeTwoLists(list1, list2);
        Assert.assertNull(actual);
    }

    @Test
    public void testLeetCode3() {
        list1 = null;
        list2 = new ListNode(0);
        expected = new ListNode(0);
        actual = cut.mergeTwoLists(list1, list2);
        Assert.assertEquals(expected, actual);
    }
}
