package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Permutation - I
 * Leetcode problem no 46
 * 
 */

public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;   
    }

    static void backtrack(int [] nums, int start, List<List<Integer>> result){
        if(start == nums.length){
            List<Integer> temp = new ArrayList<>();
            for (int n : nums) {
                temp.add(n);
            }
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    static void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
