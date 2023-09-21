
package io.github.mharbol.leetcode;

import io.github.mharbol.util.ListNode;

/**
 * MergeTwoSortedLists
 *
 * Wrapper class for LeetCode 21
 */
public class MergeTwoSortedLists {

    /**
     * Merges two sorted {@link ListNode}s.
     *
     * @param list1 the first list
     * @param list2 the second list
     * @return the merge of the two lists
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // exit case: one or both is null
        if (list1 == null || list2 == null) {
            return (list1 == null ? list2 : list1);
        }

        ListNode head, curr;

        // assign starting node and progress it
        if (list1.val < list2.val) {
            curr = list1;
            list1 = list1.next;
        } else {
            curr = list2;
            list2 = list2.next;
        }

        // reserve head
        head = curr;

        // exhaust one or both lists
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // attach remaining of [potentailly] non-empty list
        curr.next = (list1 == null ? list2 : list1);

        return head;
    }
}
