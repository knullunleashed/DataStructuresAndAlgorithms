package StreamsProblems;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Input :
 * {1,2,3,4,5,6,7,8,9}
 * 
 * output : 
 * {2,4,6,1,3,5,7,9}
 */

public class ReArrangeTheArray {
    public static void main(String[] args) {
        int [] myArray = {1,2,3,4,5,6,7,9};
        List<Integer> resultList = Stream.concat(IntStream.of(myArray).filter(n -> n % 2 == 0).boxed(),IntStream.of(myArray).filter(n -> n % 2 != 0).boxed()).toList();
        resultList.forEach(n -> System.out.print(n + " "));
    }    
}
