package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode problem no 90 subsets 2

public class Subsets2 {
    public static List<List<Integer>> subsets(int nums[]){
        Arrays.sort(nums);
        List<List<Integer>> result =  new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int[]nums, int start, List<Integer>temp, List<List<Integer>>result){
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {

            if(i > start && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);

        }

    }

    public static void main(String[] args) {
        int nums [] = {1, 2, 2};
        System.out.println(subsets(nums));
    }
}
