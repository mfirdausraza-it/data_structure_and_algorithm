package com.codecafe.dsa_pattern.fastslow_pointer;

public class ReorderList {

    public void reorderList(ListNode head) {
        // Edge case: empty list or single node → nothing to reorder
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list (left middle for even length)
        ListNode middle = findMiddle(head);

        // Step 2: Split the list into two halves
        ListNode secondHalf = middle.next;
        middle.next = null;  // Break the list to avoid cycles

        // Step 3: Reverse the second half
        secondHalf = reverse(secondHalf);

        // Step 4: Merge the two halves alternately
        ListNode firstHalf = head;

        while (secondHalf != null) {
            // Store next pointers before modifying links
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            // Link nodes alternately
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            // Move pointers forward
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    // Function to find middle (returns left middle in even case)
    static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move fast by 2 and slow by 1
        // Stops at left middle for even-length list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to reverse a linked list
    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // store next node
            curr.next = prev;              // reverse link
            prev = curr;                   // move prev forward
            curr = nextNode;               // move curr forward
        }

        return prev; // new head of reversed list
    }
}
