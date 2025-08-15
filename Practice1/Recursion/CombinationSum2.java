package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode problem no 40 - Combination Sum II

public class CombinationSum2 {
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int[] candidates, int start, int target, List<Integer>temp, List<List<Integer>>result){
   
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;   
        }

        if(target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            temp.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }    
}
