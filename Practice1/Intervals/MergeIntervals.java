package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int [] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if(current[1] >=  intervals[i][0]){
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int [][] Interval1 = {{1,3},{2,6},{8,10},{15,18}};
        int [][] Interval2 = {{1,4},{4,5}};

        System.out.println(Arrays.deepToString(merge(Interval1)));
        System.out.println(Arrays.deepToString(merge(Interval2)));
    }    
}
