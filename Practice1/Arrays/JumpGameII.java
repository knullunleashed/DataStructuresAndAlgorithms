package Arrays;

public class JumpGameII {

    public static int jump(int[] nums) {

        if(nums.length == 1){
            return 0;
        }

        int maximumReach = 0;
        int steps = 0;
        int endOfSteps = 0;

        for (int i = 0; i < nums.length; i++) {

            maximumReach = Math.max(maximumReach, i + nums[i]);

            if(i == endOfSteps){
                steps++;
                endOfSteps = maximumReach;

                if(endOfSteps >= nums.length - 1){
                    break;
                }
            }
        }
        return steps;
    }
    
    public static void main(String[] args) {
 
        int [] firstArray = {2,3,1,1,4};
        int [] secondArray = {2,3,0,1,4};

        System.out.println(jump(firstArray));
        System.out.println(jump(secondArray));

    }

}
