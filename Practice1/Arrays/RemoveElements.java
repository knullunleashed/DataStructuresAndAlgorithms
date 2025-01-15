package Arrays;

public class RemoveElements {
    public static int removeElementsFromAnArray(int[] nums, int val) {
        int i = 0;
        int j = 0;

        while(i < nums.length){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
    public static void main(String[] args) {
        int nums[] = {3,2,2,3};
        int val = 3;
        System.out.println(removeElementsFromAnArray(nums, val));
    }
}
