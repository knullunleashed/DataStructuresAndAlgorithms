package Strings;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static boolean canConstructUsingHashMap(String ransomNote, String magazine) {
        
        Map<Character, Integer> frequencyCounterMap = new HashMap<>();

        if(ransomNote.length() > magazine.length()) return false;
        
        for(char c : magazine.toCharArray()){
            frequencyCounterMap.put(c, frequencyCounterMap.getOrDefault(c, 0) + 1);
        }

        for(char c : ransomNote.toCharArray()){
            if(!frequencyCounterMap.containsKey(c) || frequencyCounterMap.get(c) <= 0) return false;
            frequencyCounterMap.put(c, frequencyCounterMap.get(c) - 1);
        }
        
        return true;
    }
    
    public static boolean canConstruct(String ransomNote, String magazine) {
        
        int [] frequencyCounter = new int[26];

        if(ransomNote.length() > magazine.length()) return false;
        
        for(char c : magazine.toCharArray()){
            frequencyCounter[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()){
            if(frequencyCounter[c - 'a'] == 0) return false;
            frequencyCounter[c - 'a']--;
        }
        
        return true;
    }

    public static void main(String[] args) {
        String ransomNote1 = "a";
        String magazine1 = "b";

        String ransomNote2 = "aa";
        String magazine2 = "ab";

        String ransomNote3 = "aa";
        String magazine3 = "aab";

        System.out.println(canConstruct(ransomNote1, magazine1));
        System.out.println(canConstruct(ransomNote2, magazine2));
        System.out.println(canConstruct(ransomNote3, magazine3));

        System.out.println("\n\n");

        System.out.println(canConstructUsingHashMap(ransomNote1, magazine1));
        System.out.println(canConstructUsingHashMap(ransomNote2, magazine2));
        System.out.println(canConstructUsingHashMap(ransomNote3, magazine3));
    }    
}
