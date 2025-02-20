package Arrays;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    /*
     * 
     * Integer to roman conversion using 
     * Hashmaps
     * 
     * The approach usually moves from right to left
     * 
     */

    static final Map<Integer, String> onesMap = new HashMap<>();
    static final Map<Integer, String> tensMap = new HashMap<>();
    static final Map<Integer, String> hundredsMap = new HashMap<>();
    static final Map<Integer, String> thousandsMap = new HashMap<>();

    static {
        onesMap.put(1, "I"); onesMap.put(2, "II"); onesMap.put(3, "III"); 
        onesMap.put(4, "IV"); onesMap.put(5, "V"); onesMap.put(6, "VI");
        onesMap.put(7, "VII"); onesMap.put(8, "VIII"); onesMap.put(9, "IX");

        tensMap.put(1, "X"); tensMap.put(2, "XX"); tensMap.put(3, "XXX");
        tensMap.put(4, "XL"); tensMap.put(5, "L"); tensMap.put(6, "LX");
        tensMap.put(7, "LXX"); tensMap.put(8, "LXXX"); tensMap.put(9, "XC");

        hundredsMap.put(1, "C"); hundredsMap.put(2, "CC"); hundredsMap.put(3, "CCC");
        hundredsMap.put(4, "CD"); hundredsMap.put(5, "D"); hundredsMap.put(6, "DC");
        hundredsMap.put(7, "DCC"); hundredsMap.put(8, "DCCC"); hundredsMap.put(9, "CM");

        thousandsMap.put(1, "M"); thousandsMap.put(2, "MM"); thousandsMap.put(3, "MMM");
    }

    public static String intToRoman(int num) {
        StringBuilder romanBuilder = new StringBuilder();

        int ones = num % 10; num /= 10;
        int tens = num % 10; num /= 10;
        int hundreds = num % 10; num /= 10;
        int thousands = num % 10; num /= 10;

        if(thousands > 0) romanBuilder.append(thousandsMap.get(thousands));
        if(hundreds > 0) romanBuilder.append(hundredsMap.get(hundreds));
        if(tens > 0) romanBuilder.append(tensMap.get(tens));
        if(ones > 0) romanBuilder.append(onesMap.get(ones));

        return romanBuilder.toString();
    }

    /*
     * 
     * Greedy Approach:
     */

    static final int [] values = {1000, 900, 500, 400, 100, 
                                  90, 50, 40, 10, 
                                  9, 5, 4, 1};
    static final String [] symbols = {"M", "CM", "D", "CD", "C",
                                      "XC", "L", "XL", "X",
                                      "IX", "V", "IV", "I"};

    public static String integerToRomanUsingGreedyApproach(int num){
        
        StringBuilder romanBuilder = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while(num >= values[i]){
                num -= values[i];
                romanBuilder.append(symbols[i]);
            }
        }

        return romanBuilder.toString();
    }

    public static void main(String[] args) {
        int num = 1987;
        System.out.println(intToRoman(num));
        System.out.println(integerToRomanUsingGreedyApproach(num));
    }    
}
