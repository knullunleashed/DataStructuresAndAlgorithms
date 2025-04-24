package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintCharacterCountInAString {
    public static void countCharactersInAString(String str){
        char [] charArray = str.toCharArray();
        Map<Character, Integer>frequencyMap = new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            if(frequencyMap.containsKey(charArray[i])){
                frequencyMap.put(charArray[i], frequencyMap.get(charArray[i]) + 1);
            } else {
                frequencyMap.put(charArray[i], 1);
            }
        }
        frequencyMap.forEach((k,v) -> System.out.print(k+""+v));
    }
    public static void main(String[] args) {
        String stringExample = "aaaabbccccdddd";
        countCharactersInAString(stringExample);
        Map<Character, Long> anotherFrequencyMap = stringExample.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println();
        anotherFrequencyMap.forEach((k,v) -> System.out.print(k+""+v));
    }   
}
