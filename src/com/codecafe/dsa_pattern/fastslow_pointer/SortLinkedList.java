package com.codecafe.dsa_pattern.fastslow_pointer;

public class SortLinkedList {


    public ListNode sortList(ListNode head) {
        // Base case: if list has 0 or 1 node, it's already sorted
        if (head == null || head.next == null) return head;

        // Step 1: Find middle of the list (we get LEFT middle for balanced split)
        ListNode middle = middle(head);

        // Step 2: Split the list into two halves
        ListNode secondHead = middle.next;

        // 🔥 VERY IMPORTANT:
        // We must break the link BEFORE recursion
        // Otherwise, 'head' will still point to the full list,
        // causing infinite recursion or incorrect splitting
        middle.next = null;

        // Step 3: Recursively sort both halves
        ListNode first = sortList(head);         // first half
        ListNode second = sortList(secondHead);  // second half

        // Step 4: Merge the sorted halves
        return mergeSortedList(first, second);
    }


    // Function to find the middle of the linked list
    static ListNode middle(ListNode node){

        // Edge case: 0 or 1 node
        if(node == null || node.next == null) return node;

        // 🔥 Key Trick:
        // fast starts from node.next (not node)
        // This ensures we return the LEFT middle in even-length lists
        // → helps split the list into equal halves

        ListNode slow = node;
        ListNode fast = node.next;

        // Move slow by 1 and fast by 2
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow now points to LEFT middle
        return slow;
    }

    static ListNode mergeSortedList(ListNode list1, ListNode list2){

        // If one list is empty, return the other
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        // Dummy node to simplify merging logic
        ListNode dummy = new ListNode();
        ListNode node = dummy;

        // Merge while both lists have elements
        while(list1 != null && list2 != null){

            // Pick the smaller node and attach it
            if(list1.val <= list2.val){
                node.next = list1;   // reuse existing node
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }

            node = node.next; // move forward
        }

        // Attach remaining nodes (only one list will have leftovers)
        if(list1 != null) node.next = list1;
        if(list2 != null) node.next = list2;

        // Return merged list (skip dummy)
        return dummy.next;
    }

}
