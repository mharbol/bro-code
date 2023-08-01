
package io.github.mharbol.brocode.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the {@link ListNode} class.
 */
public class ListNodeTest {

    /**
     * Runs before each test
     */
    @Before
    public void setup() {
    }

    /**
     * Test equality on default nodes.
     */
    @Test
    public void testDefaultEqual() {
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        Assert.assertEquals(list1, list2);
    }

    /**
     * Test equality on single node
     */
    @Test
    public void testSingleEqual() {
        ListNode list1 = new ListNode(49);
        ListNode list2 = new ListNode(49);
        Assert.assertEquals(list1, list2);
    }

    /**
     * Test inequality on single node
     */
    @Test
    public void testSingleNotEqual() {
        ListNode list1 = new ListNode(49);
        ListNode list2 = new ListNode(62);
        Assert.assertNotEquals(list1, list2);
    }

    /**
     * Test equality on linked lists
     */
    @Test
    public void testLinkedListEqual() {

        ListNode list1Node4 = new ListNode(4);
        ListNode list1Node3 = new ListNode(3, list1Node4);
        ListNode list1Node2 = new ListNode(2, list1Node3);
        ListNode list1Node1 = new ListNode(1, list1Node2);

        ListNode list2Node4 = new ListNode(4);
        ListNode list2Node3 = new ListNode(3, list2Node4);
        ListNode list2Node2 = new ListNode(2, list2Node3);
        ListNode list2Node1 = new ListNode(1, list2Node2);

        Assert.assertEquals(list1Node1, list2Node1);
    }

    /**
     * Test inequality against null
     */
    @Test
    public void testNotEqualNull() {
        ListNode list1 = new ListNode();
        ListNode list2 = null;

        Assert.assertNotEquals(list1, list2);
    }

    /**
     * Test inequality on linked lists of equal lengths
     */
    @Test
    public void testLinkedListNotEqual() {

        ListNode list1Node4 = new ListNode(10000);
        ListNode list1Node3 = new ListNode(3, list1Node4);
        ListNode list1Node2 = new ListNode(2, list1Node3);
        ListNode list1Node1 = new ListNode(1, list1Node2);

        ListNode list2Node4 = new ListNode(4);
        ListNode list2Node3 = new ListNode(3, list2Node4);
        ListNode list2Node2 = new ListNode(2, list2Node3);
        ListNode list2Node1 = new ListNode(1, list2Node2);

        Assert.assertNotEquals(list1Node1, list2Node1);
        Assert.assertNotEquals(list2Node1, list1Node1);
    }

    /**
     * Test inequality on similar linked lists of unequal lengths
     */
    @Test
    public void testLinkedListNotEqualDiffLength() {

        ListNode list1Node5 = new ListNode(5);
        ListNode list1Node4 = new ListNode(4, list1Node5);
        ListNode list1Node3 = new ListNode(3, list1Node4);
        ListNode list1Node2 = new ListNode(2, list1Node3);
        ListNode list1Node1 = new ListNode(1, list1Node2);

        ListNode list2Node4 = new ListNode(4);
        ListNode list2Node3 = new ListNode(3, list2Node4);
        ListNode list2Node2 = new ListNode(2, list2Node3);
        ListNode list2Node1 = new ListNode(1, list2Node2);

        Assert.assertNotEquals(list1Node1, list2Node1);
        Assert.assertNotEquals(list2Node1, list1Node1);
    }
}