package com.codecafe.dsa_pattern.fast_slow_pointer;

public class RemoveFromLastN {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create dummy node to handle edge case (removing head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 1: Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 2: Move both pointers together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 3: Remove the target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
