package com.codecafe.dsa_pattern.fastslow_pointer;

public class DetectCycle {

    //https://leetcode.com/problems/linked-list-cycle-ii/

    public ListNode detectCycle(ListNode head) {
        // If list is empty or has only one node → no cycle possible
        if (head == null || head.next == null) return null;

        // Initialize two pointers
        // slow → moves 1 step
        // fast → moves 2 steps
        ListNode fast = head;
        ListNode slow = head;

        // Step 1: Detect if a cycle exists using Floyd’s Algorithm
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // move 2 steps
            slow = slow.next;       // move 1 step

            // If they meet → cycle exists
            if (fast == slow) break;
        }

        // If no cycle (fast reached end), return null
        if (fast == null || fast.next == null) return null;

        // Step 2: Find the starting node of the cycle
        // Move fast to head, keep slow at meeting point
        fast = head;

        // Move both one step at a time
        // They will meet at the cycle start
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        // Return the node where cycle begins
        return fast;
    }
}
