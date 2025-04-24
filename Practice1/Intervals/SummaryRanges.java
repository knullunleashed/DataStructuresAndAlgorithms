package Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> rangeList = new ArrayList<>();
        if (nums.length == 0) return rangeList;
        int i = 0;
        int j = 0;

        while (j < nums.length - 1) {
            if(nums[j] + 1 != nums[j + 1]){
                if(i == j){
                    rangeList.add(""+nums[j]+"");
                } else {
                    rangeList.add(nums[i]+"->"+nums[j]);
                }
                i = j + 1;
            }
            j++;
        }

        if (i == j) {
            rangeList.add("" + nums[j]);
        } else {
            rangeList.add(nums[i] + "->" + nums[j]);
        }


        return rangeList;
    }

    public static void printList(List<String> result) {
        for (String element : result) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] firstArray = {0,1,2,4,5,7};
        int [] secondArray = {0,2,3,4,6,8,9};

        printList(summaryRanges(firstArray));
        printList(summaryRanges(secondArray));
    }
    
}