package Strings;

public class FirstOccurenceInAString {

    //sliding window solution
    /*
     * 
     * 🔹 Explanation of m - n + 1 in the Loop
     * We iterate from i = 0 to i = m - n to ensure that we only check valid substrings of haystack that are at least n characters long (same length as needle).
     * 
     * Example: Searching "sad" in "sadbutsad"
     * 
     * haystack = "sadbutsad"   (length = m = 9)
     * needle   = "sad"         (length = n = 3)
     * We need to check every substring of length 3 within "sadbutsad".
     * 👉 If we start at index i = 7, the substring would be:
     * haystack.substring(7, 7 + 3) -> "ad" (Index Out of Bounds ❌)
     * This is why we stop at m - n = 9 - 3 = 6.
     * 
     */
    public static int strStrSlidingWindowSolution(String haystack, String needle) {
        
        int m = haystack.length();
        int n = needle.length();

        if (n > m) return -1;

        for (int i = 0; i <= m - n; i++) {
            if(haystack.substring(i, i + n).equals(needle)){
                return i;
            }
        }

        return -1;
        
    }

    //inbuild method solution
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String hayStack1 = "sadbutsad";
        String needle1 = "sad";
        String hayStack2 = "leetcode";
        String needle2 = "leeto";

        System.out.println("\nInbuild string method solution");
        System.out.println(strStr(hayStack1, needle1));
        System.out.println(strStr(hayStack2, needle2));

        System.out.println("\nSliding window solution");

        System.out.println(strStrSlidingWindowSolution(hayStack1, needle1));
        System.out.println(strStrSlidingWindowSolution(hayStack2, needle2));
    }    
}
