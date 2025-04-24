package Strings;

public class IsSubSequence {

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        char [] subStringCharArray = s.toCharArray();
        char [] stringArray = t.toCharArray();

        int i = 0, j = 0;

        while(i < subStringCharArray.length && j < stringArray.length){
            if(subStringCharArray[i] == stringArray[j]){
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        String subStringExample1 = "abc";
        String example1 = "ahbgdc"; 

        String subStringExample2 = "axc";
        String example2 = "ahbgdc"; 

        System.out.println(isSubsequence(subStringExample1, example1));
        System.out.println(isSubsequence(subStringExample2, example2));
    }   
}
