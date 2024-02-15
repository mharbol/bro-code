
package io.github.mharbol.util;

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
        Assert.assertNotEquals(list2, list1);
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

    @Test
    public void testToStringSimple() {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node0 = new ListNode(0, node1);

        Assert.assertEquals(node0.toString(), "0 -> 1 -> 2 -> 3 -> null");
    }

    @Test
    public void testListNodeStaticConstructor() {
        ListNode expected = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(2, new ListNode(4)))));
        ListNode actual = ListNode.newList(4, 5, 6, 2, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListNodeStaticConstructorLength1() {
        ListNode expected = new ListNode(49);
        ListNode actual = ListNode.newList(49);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListNodeStaticConstructorLength0() {
        Assert.assertNull(ListNode.newList());
    }
}
