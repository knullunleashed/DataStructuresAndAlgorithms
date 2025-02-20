package Arrays;

public class LengthOfTheLastWord {
    public static int lengthOfLastWord(String s) {
        String [] wordsArray = s.split(" ");
        return wordsArray[wordsArray.length - 1].length();
    }
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
}
