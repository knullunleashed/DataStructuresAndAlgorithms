package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0 || newInterval.length == 0) return new int[0][0];

        List<int[]> result = new ArrayList<>();
        boolean inserted = false;
        
        for (int[] interval : intervals) {
            if(interval[1] < newInterval[0]){
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                if(!inserted){
                    result.add(newInterval);
                    inserted = true;
                }
                result.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        if(!inserted){
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int [][] Interval1 = {{1,3},{6, 9}};
        int []newInterval1 = {2, 5};

        int [][] Interval2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int []newInterval2 = {4, 8};

        System.out.println(Arrays.deepToString(insert(Interval1, newInterval1)));
        System.out.println(Arrays.deepToString(insert(Interval2, newInterval2)));
    }    
}
