package com.codecafe.dsa_pattern.fast_slow_pointer;

public class HasCycleLinkedList {

    //https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        // If list is empty or has only one node, it can't have a cycle
        if (head == null || head.next == null) return false;

        // Initialize two pointers:
        // slow moves 1 step at a time
        // fast moves 2 steps at a time
        ListNode fast = head;
        ListNode slow = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            // Move fast pointer by 2 steps
            fast = fast.next.next;

            // Move slow pointer by 1 step
            slow = slow.next;

            // If fast and slow meet, cycle exists
            if (fast == slow) return true;
        }

        // If we reach here, fast pointer reached end → no cycle
        return false;
    }
}
