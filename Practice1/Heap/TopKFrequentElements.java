package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int result [] = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }

    public static int[] topKFrequentUsingBucketSort(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        @SuppressWarnings("unchecked")
        List<Integer>[]buckets = new List[nums.length + 1];

        for(int key: frequencyMap.keySet()){
            int freq = frequencyMap.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k ; i--) {
            if(buckets[i] != null){
                result.addAll(buckets[i]);
            }
        }

        return result.stream().mapToInt(i -> i).limit(k).toArray();
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        int k = 2;

        Arrays.stream(topKFrequent(nums, k)).forEach((n) -> {
            System.out.println(n);
        });

        Arrays.stream(topKFrequentUsingBucketSort(nums, k)).forEach((n) -> {
            System.out.println(n);
        });
    }    
}
