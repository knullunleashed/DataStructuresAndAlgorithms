package Heap;

import java.util.PriorityQueue;

public class KthLargestIntegerInAnArray {
    public static String kthLargestNumber(String[] nums, int k) {
         // MinHeap comparator: smaller numbers have higher priority
         PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length(); // shorter number is smaller
            } else {
                return a.compareTo(b); // same length → lexicographic
            }
        });

        for (String n: nums) {
            minHeap.add(n);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }

    public static void main(String[] args) {
        String nums[] = {"3","6","7","10"};
        int k = 4;
        System.out.println(kthLargestNumber(nums, k));
    }    
}
