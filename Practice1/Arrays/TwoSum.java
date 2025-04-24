package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //Two pointer approach can only be used if the input is sorted
    public static int[] twoSumUsingTwoPointers(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{left, right};
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum(int[] nums, int target) {
            int [] result = new int[2];
            Map<Integer, Integer> searchMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int sum = target - nums[i];
                if (!searchMap.containsKey(sum)) {
                    searchMap.put(nums[i], i);
                } else {
                    result[0] = searchMap.get(sum);
                    result[1] = i;
                    break;
                }
            }
            return result;
    }

    public static void printResult(int [] result){
        for (int i : result) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] example1 = {2,7,11,15};
        int target1 = 9;

        int [] example2 = {3, 2, 4};
        int target2 = 6;

        int [] example3 = {3, 3};
        int target3 = 6;

        int resultArray1[] = twoSum(example1, target1);
        int resultArray2[] = twoSum(example2, target2);
        int resultArray3[] = twoSum(example3, target3);

        int resultArray4[] = twoSumUsingTwoPointers(example1, target1);
        int resultArray5[] = twoSumUsingTwoPointers(example2, target2);
        int resultArray6[] = twoSumUsingTwoPointers(example3, target3);

        printResult(resultArray1);
        printResult(resultArray2);
        printResult(resultArray3);

        System.out.println();

        printResult(resultArray4);
        printResult(resultArray5);
        printResult(resultArray6);
    }    
}
