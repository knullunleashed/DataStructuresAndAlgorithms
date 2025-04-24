package Strings;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        char [] characterArray = s.toLowerCase().toCharArray();
        int left = 0;
        int right = characterArray.length - 1;

        while(left < right){
 
            while (left < right && !Character.isLetterOrDigit(characterArray[left])) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(characterArray[right])) {
                right--;
            }

            if(characterArray[left] != characterArray[right]){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String example1 = "A man, a plan, a canal: Panama";
        String example2 = "race a car";
        String example3 = " ";

        System.out.println(isPalindrome(example1));
        System.out.println(isPalindrome(example2));
        System.out.println(isPalindrome(example3));
    }    
}
