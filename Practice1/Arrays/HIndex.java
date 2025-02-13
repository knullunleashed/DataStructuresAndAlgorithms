package Arrays;

import java.util.Arrays;

public class HIndex {

    public static int hIndexUsingSorting(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if(citations[i] >= h){
                return h;
            }
        }
        return 0;
    }

    public static int hIndexUsingCountArrayBucket(int[] citations) {

        int n = citations.length;
        int frequencyArray [] = new int[n + 1];

        for (int citation : citations) {
            if (citation >= n) {
                frequencyArray[n]++;
            } else {
                frequencyArray[citation]++;
            }
        }
        
        int totalNumberOfPapersPublished = 0;

        for (int h = n; h >= 0; h--) {
            totalNumberOfPapersPublished += frequencyArray[h];

            if(totalNumberOfPapersPublished >= h){
                return h;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        int arr1[] = {3,0,6,1,5};
        int arr2[] = {1,3,1};
        int arr3[] = {4,4,4,4,4,4,4,7};

        System.out.println("The citation of first array is :"+hIndexUsingSorting(arr1));
        System.out.println("The citation of second array is :"+hIndexUsingSorting(arr2));
        System.out.println("The citation of third array is :"+hIndexUsingSorting(arr3));

        System.out.println("The citation of first array is :"+hIndexUsingCountArrayBucket(arr1));
        System.out.println("The citation of second array is :"+hIndexUsingCountArrayBucket(arr2));
        System.out.println("The citation of third array is :"+hIndexUsingCountArrayBucket(arr3));
    }
    
}
