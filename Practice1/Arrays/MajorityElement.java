package Arrays;

import java.util.Arrays;

/*
 * 
 * Majority Element
 * 
 * Level : very easy
 * 
 * topic : Hashmap, sorting, Boore-Mayer voting algorithm
 * 
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * 
 */


public class MajorityElement {


    /*
     * 
     * Boyer Moore voting algorithm
     * 
     * Below algorithm finds the majority element in 
     * O(n) -> Time complexity
     * O(1) -> Space complexity
     */
    public static int majorityElementUsingBoyerMooreVotingAlgorithm(int [] nums){

        int result = 0;
        int majority = 0;

        for (int i : nums) {
            if(majority == 0){
                result = i;
            }
            majority += i == result ? 1 : -1;
        }
        return result;
    }

    /*
     * Below algorithm finds the majority element in 
     * o(NlogN) -> Time complexity
     * O(1) -> Space complexity
     */
    public static int majorityElement(int [] nums){
        Arrays.sort(nums);

        int count = 0;
        int n = nums.length;
        int result = 0;

        if(nums.length == 1){
            return nums[0];
        }

        for (int i = 1; i < n; i++) {
            if(nums[i - 1] == nums[i]){
                count++;
                if(count == n/2){
                    result = nums[i];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int [] nums = {3,2,3};
        int [] nums2 = {2,2,1,1,1,2,2};
        int [] nums3 = {1};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums2));
        System.out.println(majorityElement(nums3));
        System.out.println(majorityElementUsingBoyerMooreVotingAlgorithm(nums));
        System.out.println(majorityElementUsingBoyerMooreVotingAlgorithm(nums2));
        System.out.println(majorityElementUsingBoyerMooreVotingAlgorithm(nums3));
    }    
}
