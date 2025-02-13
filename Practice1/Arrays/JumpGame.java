package Arrays;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        // if(nums.length == 1){
        //     return true;
        // }
        // int index = 0;
        // while (index < nums.length) {

        //     if(nums[index] == 0){
        //         return false;
        //     }

        //     if(nums.length - 1 == index){
        //         return true;
        //     }

        //     index = index + nums[index];
        // }

        // return false;

        int maximumReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if(maximumReach > nums.length){
                return false;
            }

            maximumReach = Math.max(maximumReach, i + nums[i]);

            if(maximumReach == nums.length - 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] firstArray = {2,3,1,1,4};
        int [] secondArray = {3,2,1,0,4};

        System.out.println(canJump(firstArray));
        System.out.println(canJump(secondArray));
    }
    
}
