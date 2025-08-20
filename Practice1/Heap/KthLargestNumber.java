package Heap;

import java.util.PriorityQueue;

/*
 * 
 * Leetcode problem no 215
 * 
 */

public class KthLargestNumber {
    
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add(n);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }

    public static void main(String[] args) {
        int nums[] = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        System.out.println(findKthLargest(nums, k));
    }    
}
