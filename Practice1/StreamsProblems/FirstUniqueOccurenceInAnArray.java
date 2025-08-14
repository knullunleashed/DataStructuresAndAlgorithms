package StreamsProblems;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueOccurenceInAnArray {
    public static void main(String[] args) {
        int arr[] = {5,5,1,2,4,3,3};
        Map<Integer, Long> frequencyMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(int num : arr){
            if(frequencyMap.get(num) == 1){
                System.out.println(num);
                break;
            }
        }
    }    
}
