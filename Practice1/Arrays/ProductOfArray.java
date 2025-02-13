package Arrays;

public class ProductOfArray {


    public static int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int answer [] =  new int[n];
        answer[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i]; 
        }

        return answer;
    }

    public static void main(String[] args) {
        int firstArray [] = {1,2,3,4};
        int secondArray [] = {-1,1,0,-3,3};

        int firstResult [] = productExceptSelf(firstArray);
        int secondResult [] = productExceptSelf(secondArray);

        System.out.println("\nThe result of the first array is : ");

        for (int i : firstResult) {
            System.out.print(" "+i);
        }

        System.out.println("\nThe result of the second array is : ");

        for (int i : secondResult) {
            System.out.print(" "+i);
        }

    }
    
}
