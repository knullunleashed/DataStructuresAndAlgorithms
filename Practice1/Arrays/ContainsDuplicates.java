package Arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> searchMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(searchMap.containsKey(nums[i])){
                if(i - searchMap.get(nums[i]) <= k){
                    return true;
                }
            }
            searchMap.put(nums[i], i);
        }
        return false;

    }

    public static void main(String[] args) {
        int [] example1 = {1,2,3,1};
        int k1 = 3;

        int [] example2 = {1,0,1,1};
        int k2 = 1;

        int [] example3 = {1,2,3,1,2,3};
        int k3 = 2;

        System.out.println(containsNearbyDuplicate(example1, k1));
        System.out.println(containsNearbyDuplicate(example2, k2));
        System.out.println(containsNearbyDuplicate(example3, k3));        
    }    
}
