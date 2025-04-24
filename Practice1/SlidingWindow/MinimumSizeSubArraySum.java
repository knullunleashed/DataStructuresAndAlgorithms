package SlidingWindow;

public class MinimumSizeSubArraySum {
    
    public static int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int left = 0;
        int minimumLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while(currentSum >= target){
                if(right - left + 1 < minimumLength){
                    minimumLength = right - left + 1;
                }

                currentSum -= nums[left];
                left++;
            }
        }

        return minimumLength != Integer.MAX_VALUE ? minimumLength : 0;
    }

    public static void main(String[] args) {
        int arr1[] = {2,3,1,2,4,3};
        int target1 = 7;
        
        int arr2[] = {1,4,4};
        int target2 = 4;

        int arr3[] = {1,1,1,1,1,1,1,1};
        int target3 = 11;

        System.out.println(minSubArrayLen(target1, arr1));
        System.out.println(minSubArrayLen(target2, arr2));
        System.out.println(minSubArrayLen(target3, arr3));
    }
}
