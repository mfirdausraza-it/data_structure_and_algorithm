package com.codecafe.dsa_pattern.fast_slow_pointer;

public class FindMiddle {



//    https://leetcode.com/problems/middle-of-the-linked-list

    public ListNode middleNode(ListNode head) {

        // Base case: single node or empty list → return as is
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;   // Slow pointer moves 1 step per iteration
        ListNode fast = head;   // Fast pointer moves 2 steps per iteration

        // Tortoise and Hare algorithm:
        // Fast pointer reaches the end roughly when slow reaches the middle
        while (fast != null && fast.next != null) {

            // Advance fast by TWO nodes
            fast = fast.next.next;

            // Advance slow by ONE node
            slow = slow.next;
        }

        // At this point, slow is at the middle node
        return slow;
    }
}
