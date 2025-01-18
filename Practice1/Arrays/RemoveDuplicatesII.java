package Arrays;

public class RemoveDuplicatesII {

    public static int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 1] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }    
}
