package Arrays;

// import java.util.HashMap;
// import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        
        // Map<Character, Integer> romanToIntegerMapping = new HashMap<>();
        // romanToIntegerMapping.put('I', 1);
        // romanToIntegerMapping.put('V', 5);
        // romanToIntegerMapping.put('X', 10);
        // romanToIntegerMapping.put('L', 50);
        // romanToIntegerMapping.put('C', 100);
        // romanToIntegerMapping.put('D', 500);
        // romanToIntegerMapping.put('M', 1000);

        /*
         * Inorder to reduce constant time overhead we are using array 
         * instead of hashmap. As Arrays are usually faster than hashmap
         * but both the soln are in 0(n) time complexity hence hashmap can also be used
         */

        int[] values = new int[128]; // Inorder to increase the speed we are using arrays instead of hashmap 
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        char [] romanNumeralArray = s.toCharArray();
        int integerValue = 0;
        int n = romanNumeralArray.length;

        integerValue += values[romanNumeralArray[n - 1]];
        for (int i = n - 2; i >= 0; i--) {
            int currentVal = values[romanNumeralArray[i]];
            int nextVal = values[romanNumeralArray[i + 1]];
            if(currentVal < nextVal){
                integerValue -= values[romanNumeralArray[i]];
            } else {
                integerValue += values[romanNumeralArray[i]];
            }
        }
        return integerValue;
    }
    public static void main(String[] args) {
        String firstRomanNumeral = "III";
        String secondRomanNumeral = "LVIII";
        String thirdRomanNumeral = "MCMXCIV";
        String fourthRomanNumeral = "XL";
        String fifthRomanNumeral = "IX";
        String sixthRomanNumeral = "IV";

        System.out.println("The "+firstRomanNumeral+" equivalent of integer is :"+romanToInt(firstRomanNumeral));
        System.out.println("The "+secondRomanNumeral+" equivalent of integer is :"+romanToInt(secondRomanNumeral));
        System.out.println("The "+thirdRomanNumeral+" equivalent of integer is :"+romanToInt(thirdRomanNumeral));
        System.out.println("The "+fourthRomanNumeral+" equivalent of integer is :"+romanToInt(fourthRomanNumeral));
        System.out.println("The "+fifthRomanNumeral+" equivalent of integer is :"+romanToInt(fifthRomanNumeral));
        System.out.println("The "+sixthRomanNumeral+" equivalent of integer is :"+romanToInt(sixthRomanNumeral));
    }
}
