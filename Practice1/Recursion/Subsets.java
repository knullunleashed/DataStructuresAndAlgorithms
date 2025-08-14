package Recursion;

import java.util.ArrayList;
import java.util.List;

//Leetcode problem no  78

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int[] nums, int start, List<Integer>temp, List<List<Integer>>result) {
        
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        int []nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }    
}
