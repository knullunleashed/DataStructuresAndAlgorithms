package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Top K frequent words
 * 
 * Leetcode Problem no : 692
 * 
 * Level : Medium
 * 
 * 
 * 
 */

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> frequencyCounter = new HashMap<>();

        for (String word : words) {
            frequencyCounter.put(word, frequencyCounter.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey().compareTo(a.getKey()); 
            }
            return a.getValue() - b.getValue(); 
        });

        for(Map.Entry<String, Integer>entry : frequencyCounter.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        String [] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;

        System.out.println(topKFrequent(words, k));
    }
}
