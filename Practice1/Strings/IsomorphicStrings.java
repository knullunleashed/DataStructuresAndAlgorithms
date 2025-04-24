package Strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sCharacter = s.charAt(i);
            char tCharacter = t.charAt(i);

            if(charMap.containsKey(sCharacter)){
                if(charMap.get(sCharacter) != tCharacter){
                    return false;
                }
            } else if (charMap.containsValue(tCharacter)) {
                return false;
            }

            charMap.put(sCharacter, tCharacter);
        }
        return true;
    }

    public static boolean isIsomorphicUsingTwoHashMaps(String s, String t) {
        if(s.length() != t.length()) return false;

        char [] sCharArray = s.toCharArray();
        char [] tCharArray = t.toCharArray();

        Map<Character, Integer> sCharacterMap = new HashMap<>();
        Map<Character, Integer> tCharacterMap = new HashMap<>();

        for (int i = 0; i < sCharArray.length; i++) {
            sCharacterMap.put(sCharArray[i], i);
        }

        for (int i = 0; i < tCharArray.length; i++) {
            tCharacterMap.put(tCharArray[i], i);
        }

        for (int i = 0; i < sCharArray.length; i++) {
            if(!sCharacterMap.get(sCharArray[i]).equals(tCharacterMap.get(tCharArray[i]))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("egc", "add"));
        System.out.println(isIsomorphicUsingTwoHashMaps("egg", "add"));
        System.out.println(isIsomorphicUsingTwoHashMaps("egc", "add"));
    }    
}
