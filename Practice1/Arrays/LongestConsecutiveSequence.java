package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    
    public static int longestConsecutive(int[] nums) {
        Set<Integer>numSet = new HashSet<>();
        
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            if(!numSet.contains(num - 1)){
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(length, longest);
            }   
        }
        return longest;
    }
    public static void main(String[] args) {
        int arr1[] = {100,4,200,1,3,2};
        int arr2[] = {0,3,7,2,5,8,4,6,0,1};
        int arr3[] = {1,0,1,2};
        int arr4[] = {0};
        int arr5[] = {0, 0};
        int arr6[] = {};

        System.out.println(longestConsecutive(arr1));
        System.out.println(longestConsecutive(arr2));
        System.out.println(longestConsecutive(arr3));
        System.out.println(longestConsecutive(arr4));
        System.out.println(longestConsecutive(arr5));
        System.out.println(longestConsecutive(arr6));
    }    
}
