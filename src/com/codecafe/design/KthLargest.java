package com.codecafe.design;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> queue;
    int size;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>((i,j)->i-j);
        size = k;
        for(int i : nums){
            if(queue.size() >= size) {
                if(queue.peek()<i){
                    queue.poll();
                    queue.offer(i);
                }
            }else {
                queue.offer(i);
            }
        }
    }

    public int add(int val) {
        if(queue.size() >= size) {
            if(queue.peek()<val){
                queue.poll();
                queue.offer(val);
            }
        }else{
            queue.offer(val);
        }
        return queue.peek() == null ? 0 : queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3,new int[]{4,5,8,2});

    }
}