package com.codecafe.dsa_pattern.fastslow_pointer;

public class MergeKSortedList {


    public ListNode mergeKLists_BruteForce_I(ListNode[] lists) {
        int n = lists.length;

        // If no lists are given, return null
        if (n == 0) return null;

        // Start with the first list as the initial merged result
        ListNode main = lists[0];

        // Sequentially merge each list into 'main'
        // After each iteration, 'main' grows larger
        for (int i = 1; i < n; i++) {
            main = merge(lists[i], main);
        }

        // Final merged sorted list
        return main;
    }

    public ListNode mergeKLists_BruteForce_II(ListNode[] lists) {
        int n = lists.length;

        // If no lists are given, return null
        if (n == 0) return null;

        // 'main' will store the cumulative merged result
        ListNode main = null;

        // Two pointers to pick lists from start and end
        int left = 0, right = n - 1;

        // Merge pairs from both ends
        while (left < right) {

            // First merge lists[left] and lists[right]
            // Then merge that result into 'main'
            main = merge(main, merge(lists[left++], lists[right--]));
        }

        // If number of lists is odd, one list will remain unprocessed
        // Merge it into 'main'
        if (n % 2 != 0) {
            main = merge(main, lists[left]);
        }

        // Return the final merged list
        return main;
    }

    /**
     *
     */
    public ListNode mergeKLists_Optimal(ListNode[] lists) {
        int n = lists.length;

        // If no lists are given, return null
        if (n == 0) return null;

        // 'size' represents how many lists are currently active
        int size = n;

        // Keep merging until only one list remains
        while (size > 1) {

            int left = 0;
            int right = size - 1;

            // Merge pairs from both ends
            while (left < right) {

                // Merge lists[left] and lists[right]
                // Store result back at 'left' index
                lists[left] = merge(lists[left], lists[right]);

                // Move pointers inward
                left++;
                right--;
            }

            // Reduce number of active lists:
            // - size/2 → number of merged pairs
            // - size%2 → carry forward middle list if odd
            size = size / 2 + size % 2;
        }

        // Final merged list will be at index 0
        return lists[0];
    }

    static ListNode merge(ListNode list1, ListNode list2) {

        // If one list is empty, return the other
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Dummy node to simplify head handling
        ListNode dummy = new ListNode();

        // Pointer to build the merged list
        ListNode node = dummy;

        // Traverse both lists while both have nodes
        while (list1 != null && list2 != null) {

            // Always attach the smaller node to maintain sorted order
            if (list1.val <= list2.val) {
                node.next = list1;      // attach node from list1
                list1 = list1.next;     // move list1 forward
            } else {
                node.next = list2;      // attach node from list2
                list2 = list2.next;     // move list2 forward
            }

            // Move the merged list pointer forward
            node = node.next;
        }

        // Attach remaining nodes (only one of these will run)
        if (list1 != null) node.next = list1;
        if (list2 != null) node.next = list2;

        // Return head of merged list (skip dummy node)
        return dummy.next;
    }
}
