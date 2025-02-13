package Arrays;

import java.util.Arrays;

public class CandyProblem {

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int [] candyArray = new int[n];
        Arrays.fill(candyArray, 1);

        for (int i = 1; i < candyArray.length; i++) {
            if(ratings[i] > ratings[i - 1]){
                candyArray[i] = candyArray[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]){
                candyArray[i] = Math.max(candyArray[i], candyArray[i + 1] + 1);
            }
        }

        int sumOfCandies = 0;

        for (int i : candyArray) {
            sumOfCandies += i;
        }

        return sumOfCandies;

    }

    public static void main(String[] args) {
        int [] firstRating = {1,0,2};
        int [] secondRating = {1,2,2};
        int [] thirdRating = {1,3,4,5,2};

        System.out.println(candy(firstRating));
        System.out.println(candy(secondRating));
        System.out.println(candy(thirdRating));
    }    
}
