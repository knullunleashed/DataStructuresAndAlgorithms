package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char [] chars = word.toCharArray();
            Arrays.sort(chars);

            String sortedWord = new String(chars);

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String [] strs1 = {"eat","tea","tan","ate","nat","bat"};
        String [] strs2 = {""};
        String [] strs3 = {"a"};

        System.out.println(groupAnagrams(strs1));
        System.out.println(groupAnagrams(strs2));
        System.out.println(groupAnagrams(strs3));
    }
}
