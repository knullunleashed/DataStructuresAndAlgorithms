package Math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {
    
    public static boolean isHappyUsingFastAndSlowPointers(int n) {
        int slow = getHappyNumbers(n);
        int fast = getHappyNumbers(getHappyNumbers(n));

        while (slow != fast) {
            if(n == 1) return true;
            slow = getHappyNumbers(slow);
            fast = getHappyNumbers(getHappyNumbers(fast));
        }

        return slow == 1;
    }

    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (!visited.contains(n)) {
            visited.add(n);
            n = getHappyNumbers(n);
            if(n == 1){
                return true;
            }
        }
        return false;
    }

    private static int getHappyNumbers(int n){
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            output += digit * digit;
            n = n / 10;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));

        System.out.println(isHappyUsingFastAndSlowPointers(19));
        System.out.println(isHappyUsingFastAndSlowPointers(2));
    }
}
