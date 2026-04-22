package com.codecafe.dsa_pattern.fast_slow_pointer;

public class MergeTwoSortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // If one of the lists is empty, return the other
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Dummy node to simplify handling of head
        ListNode dummy = new ListNode();

        // Pointer to build the merged list
        ListNode node = dummy;

        // Traverse both lists until one becomes null
        while (list1 != null && list2 != null) {

            // Compare current values and attach the smaller node
            if (list1.val <= list2.val) {
                node.next = list1;     // link node from list1
                list1 = list1.next;    // move list1 forward
            } else {
                node.next = list2;     // link node from list2
                list2 = list2.next;    // move list2 forward
            }

            // Move the pointer of merged list forward
            node = node.next;
        }

        // If elements remain in list1, attach them
        if (list1 != null) {
            node.next = list1;
        }

        // If elements remain in list2, attach them
        if (list2 != null) {
            node.next = list2;
        }

        // Return the head of merged list (skip dummy node)
        return dummy.next;
    }
}
