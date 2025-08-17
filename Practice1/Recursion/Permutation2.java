package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * Permutation 2
 * 
 * Leetcode problem no 47
 */

public class Permutation2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean []used =  new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, used, result);
        return result;
    }

    static void backtrack(int []nums, int start, boolean[] used, List<List<Integer>>result){
        if(start == nums.length){
            List<Integer> temp = new ArrayList<>();
            for (int n : nums) {
                temp.add(n);
            }
            result.add(temp);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            
            if(i > start && nums[i] == nums[i - 1] && !used[i]) continue;

            swap(nums, start, i);
            used[i] = true;
            backtrack(nums, start + 1, used, result);
            swap(nums, start, i);
            used[i] = false;

        }
    }

    static void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
        int [] nums2 = {1, 2, 3};
        System.out.println(permuteUnique(nums2));
    }    
}
