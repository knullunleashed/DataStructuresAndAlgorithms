package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumOperationToHalveArraySum {
    public static int halveArray(int[] nums) {
        PriorityQueue<Double> pQ = new PriorityQueue<>(Collections.reverseOrder());
        double initialSum = 0;
        int numberOfOperation = 0;

        for (int num : nums) {
            initialSum += num;
            pQ.offer((double)num);
        }

        double halvedValueOfSum = initialSum/2.0;
        double currentSum = initialSum;

        while(currentSum > halvedValueOfSum){
            double sumReduction = pQ.poll()/2.0;
            currentSum -= (sumReduction);
            pQ.offer(sumReduction);
            numberOfOperation++;
        }

        return numberOfOperation;
    }

    public static void main(String[] args) {
        int [] array1 = {5,19,8,1};
        int [] array2 = {3,8,20};
        System.out.println(halveArray(array1));
        System.out.println(halveArray(array2));
    }
}