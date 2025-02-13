package Arrays;

public class TrappingRainWater {
    
    public static int trapDynamicProgrammingSolution(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }

        int []leftMax = new int[n];
        int []rightMax = new int[n];
        int water = 0;

        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;

    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        
        while (right > left) {
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int height1[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int height2[] = {4,2,0,3,2,5};
        System.out.println(trap(height1));
        System.out.println(trap(height2));
        System.out.println(trapDynamicProgrammingSolution(height1));
        System.out.println(trapDynamicProgrammingSolution(height2));
    }    
}
