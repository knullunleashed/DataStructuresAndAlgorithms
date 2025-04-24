package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutDuplicates {
    
    public static int lengthOfLongestSubstringUsingHashMap(String s) {
        Map<Character, Integer> frequencyCounter = new HashMap<>();
        int left = 0;
        int maximumLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            frequencyCounter.put(c, frequencyCounter.getOrDefault(c, 0) + 1);

            while (frequencyCounter.get(c) > 1) {
                char leftChar = s.charAt(left);
                frequencyCounter.put(leftChar, frequencyCounter.get(leftChar) - 1);
                left++;
            }
            maximumLength = Math.max(maximumLength, right - left + 1);
        }
        return maximumLength;
    }

    public static int lengthOfLongestSubstringUsingHashSet(String s) {
        int left = 0;
        Set<Character>charSet = new HashSet<>();
        int maximumLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maximumLength = Math.max(maximumLength, right - left + 1);
        }
        return maximumLength;
    }

    public static void main(String[] args) {
        String sample1 = "abcabcbb";
        String sample2 = "bbbbb";
        String sample3 = "pwwkew";

        System.out.println(lengthOfLongestSubstringUsingHashSet(sample1));
        System.out.println(lengthOfLongestSubstringUsingHashSet(sample2));
        System.out.println(lengthOfLongestSubstringUsingHashSet(sample3));

        System.out.println(lengthOfLongestSubstringUsingHashMap(sample1));
        System.out.println(lengthOfLongestSubstringUsingHashMap(sample2));
        System.out.println(lengthOfLongestSubstringUsingHashMap(sample3));
    }    
}
