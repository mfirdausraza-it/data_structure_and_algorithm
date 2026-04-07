package com.codecafe.dsa_pattern.fastslow_pointer;

import org.w3c.dom.Node;

import java.util.Stack;

public class ReverseSinglyLinkedList {


    /***   BRUTE FORCE  ***/

    /**
     * Reverses a singly linked list using a Stack (extra space approach).
     *
     * Approach:
     * 1. Push all nodes onto a stack (LIFO naturally reverses order).
     * 2. Pop the first node → becomes the new head.
     * 3. Re-link the remaining nodes by popping from stack.
     * 4. Explicitly set the last node's next pointer to null.
     *
     * Time Complexity: O(n) - two passes over the list (push + pop)
     * Space Complexity: O(n) - stack stores all nodes
     *
     * Note: This works, but the 3-pointer iterative method (prev/current/temp) is more efficient
     *       because it uses O(1) extra space.
     *
     * @param head head of the original linked list
     * @return new head of the reversed linked list
     */
    public ListNode reverseList_BruteForce(ListNode head) {

        // Edge case: empty list or single node is already reversed
        if (head == null || head.next == null) {
            return head;
        }

        // Phase 1: Push all nodes onto the stack
        // After this, the top of the stack is the original tail
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // Phase 2: Start building the reversed list
        // First pop becomes the new head of the reversed list
        ListNode newHead = stack.pop();
        ListNode current = newHead;   // Use 'current' for clarity while traversing/building

        // Phase 3: Re-link remaining nodes in reverse order
        while (!stack.isEmpty()) {
            // Pop next node and link it as the next node in reversed list
            current.next = stack.pop();
            // Move current forward to the newly added node
            current = current.next;
        }

        // Phase 4: Important - Terminate the reversed list
        // The last node (original head) must have next = null
        // Without this, the tail might still point to old nodes, causing wrong behavior or cycles
        current.next = null;

        // Return the new head of the reversed list
        return newHead;
    }

    /**
     * Reverses a singly linked list iteratively using three pointers.
     *
     * Problem: https://leetcode.com/problems/reverse-linked-list/
     *
     * Approach: Iterative reversal with O(n) time and O(1) extra space.
     * We maintain three pointers:
     *   - prev    : points to the already reversed part (initially null)
     *   - current : the node we are currently processing
     *   - temp    : temporary pointer to store the next node before breaking the link
     *
     * Time Complexity: O(n) - we traverse the list exactly once
     * Space Complexity: O(1) - only a constant number of pointers are used
     *
     * @param head The head of the original linked list
     * @return The new head of the reversed linked list
     */
    public ListNode reverseList(ListNode head) {

        // Edge case handling:
        // If the list is empty (head == null) or has only one node,
        // it is already reversed. Return as-is.
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers:
        // prev     -> null (the reversed portion starts empty)
        // current  -> head (the node we are currently reversing)
        // temp     -> will be used to save the next node before we reverse the link
        ListNode prev = null;
        ListNode current = head;
        ListNode temp = null;

        // Traverse the entire list until current becomes null
        while (current != null) {

            // Step 1: Save the next node in temp
            // This is crucial because we are about to break the current.next link
            // If we don't save it now, we will lose access to the rest of the list
            temp = current.next;

            // Step 2: Reverse the current node's next pointer
            // Make it point to the previous node instead of the original next node
            // This is the actual "reversal" step
            current.next = prev;

            // Step 3: Move the prev pointer one step forward
            // Now the current node becomes part of the reversed list
            prev = current;

            // Step 4: Move current to the next node (using the temp we saved earlier)
            // This advances us through the original list
            current = temp;
        }

        // After the loop:
        // 'prev' points to the last node of the original list,
        // which is now the new head of the fully reversed list.
        return prev;
    }

}
