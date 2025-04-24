package Strings;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    public static boolean isAnagramUsingArray(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int [] frequencyCounter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequencyCounter[s.charAt(i) - 'a']++;
            frequencyCounter[t.charAt(i) - 'a']--;
        }

        for (int count: frequencyCounter) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagramUsingSingleHashMap(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer>frequencyCounter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            frequencyCounter.put(s.charAt(i), frequencyCounter.getOrDefault(s.charAt(i), 0) + 1);
            frequencyCounter.put(t.charAt(i), frequencyCounter.getOrDefault(t.charAt(i), 0) - 1);
        }

        for(int count : frequencyCounter.values()){
            if(count != 0) return false;
        }

        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer>sFrequencyCounter = new HashMap<>();
        Map<Character, Integer>tFrequencyCounter = new HashMap<>();
        char [] sCharArray = s.toCharArray();
        char [] tCharArray = t.toCharArray();

        for (int i = 0; i < sCharArray.length; i++) {
            sFrequencyCounter.put(sCharArray[i], sFrequencyCounter.getOrDefault(sCharArray[i], 0) + 1);
        }

        for (int i = 0; i < tCharArray.length; i++) {
            tFrequencyCounter.put(tCharArray[i], tFrequencyCounter.getOrDefault(tCharArray[i], 0) + 1);
        }

        return sFrequencyCounter.equals(tFrequencyCounter);
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        System.out.println(isAnagram(s1, t1));
        System.out.println(isAnagram(s2, t2));

        System.out.println(isAnagramUsingSingleHashMap(s1, t1));
        System.out.println(isAnagramUsingSingleHashMap(s2, t2));

        System.out.println(isAnagramUsingArray(s1, t1));
        System.out.println(isAnagramUsingArray(s2, t2));
    }    
}
