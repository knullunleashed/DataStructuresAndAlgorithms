package Recursion;

import java.util.ArrayList;
import java.util.List;

//leetcode problem no 39 combination sum

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int[]candidates, int start, int target, List<Integer>temp, List<List<Integer>>result){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int [] candidates = {2,3,6,7};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }    
}
