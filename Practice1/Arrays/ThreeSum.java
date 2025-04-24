package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int value = -nums[i];

            if(i > 0 && nums[i] == nums[i - 1]) continue;
 
             while(left < right){
                int sum = nums[left] + nums[right];
 
                if(sum == value){
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if(sum < value){
                    left++;
                } else {
                    right--;
                }
             }
         }
         return resultList;
     }
    
    public static List<List<Integer>> threeSumUsingHashSet(int[] nums) {
       Arrays.sort(nums);
       Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int value = -nums[i];

            while(left < right){
                int sum = nums[left] + nums[right];

                if(sum == value){
                    List<Integer> listOfPossibleSums = Arrays.asList(nums[i], nums[left], nums[right]);
                    resultSet.add(listOfPossibleSums);
                    left++;
                    right--;
                } else if(sum < value){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    public static void printListOfLists(List<List<Integer>> listOfLists){
        for (List<Integer> list : listOfLists) {
            System.out.println(list);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int nums1[] = {-1,0,1,2,-1,-4};
        int nums2[] = {0,1,1};
        int nums3[] = {0,0,0};

        printListOfLists(threeSumUsingHashSet(nums1));
        printListOfLists(threeSumUsingHashSet(nums2));
        printListOfLists(threeSumUsingHashSet(nums3));

        printListOfLists(threeSum(nums1));
        printListOfLists(threeSum(nums2));
        printListOfLists(threeSum(nums3));
    }    
}
