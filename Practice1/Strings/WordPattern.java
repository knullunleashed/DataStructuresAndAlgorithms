package Strings;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        char patternArray[] = pattern.toCharArray();
        String stringArray[] = s.split(" ");
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        if(patternArray.length != stringArray.length) return false;

        for (int i = 0; i < stringArray.length; i++) {
            if(charToWord.containsKey(patternArray[i])){
                if(!charToWord.get(patternArray[i]).equals(stringArray[i])){
                    return false;
                }
            } else if(wordToChar.containsKey(stringArray[i])){
                if(!wordToChar.get(stringArray[i]).equals(patternArray[i])){
                    return false;
                }
            }
            charToWord.put(patternArray[i], stringArray[i]);
            wordToChar.put(stringArray[i], patternArray[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern1 = "abba";
        String exampleString1 = "dog cat cat dog";

        String pattern2 = "abba";
        String exampleString2 = "dog cat cat fish";

        String pattern3 = "aaaa";
        String exampleString3 = "dog cat cat dog";

        String pattern4 = "abba";
        String exampleString4 = "dog dog dog dog";

        System.out.println(wordPattern(pattern1, exampleString1));
        System.out.println(wordPattern(pattern2, exampleString2));
        System.out.println(wordPattern(pattern3, exampleString3));
        System.out.println(wordPattern(pattern4, exampleString4));
    }    
}
