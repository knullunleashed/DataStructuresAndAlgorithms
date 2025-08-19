package Heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> Integer.parseInt(a) -  Integer.parseInt(b));

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
