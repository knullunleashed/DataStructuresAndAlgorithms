package DynamicProgramming;

/*
 * House Robber :
 * Problem no : 198
 * 
 * Difficulty : Medium
 * 
 * 
 */

public class HouseRobber {
    public static int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        int []dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }

    public static int robWithVariables(int[] nums) {
        int previousRob = 0;
        int maxRob = 0;
        
        for (int currentValue : nums) {
            int temp = Math.max(maxRob, previousRob + currentValue);
            previousRob = maxRob;
            maxRob = temp;
        }
        return maxRob;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(rob(nums));
        System.out.println(robWithVariables(nums));
    }    
}
