package Arrays;

public class ReverseWords {

    public static String reverseWordsWithoutUsingInbuildMethods(String s) {
        
        StringBuffer result = new StringBuffer();
        int end = s.length() - 1;

        while (end >= 0) {

            while(end >= 0 && s.charAt(end) == ' ') end--;

            if(end < 0) break;

            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') start--;

            if(result.length() > 0) result.append(" ");

            result.append(s.substring(start + 1, end + 1));

            end = start - 1;

        }

        return result.toString();

    }

    //Reverse words using java inbuilt method
    public static String reverseWords(String s) {
        
        String stringArray[] = s.trim().split("\\s+");
        StringBuffer updateString = new StringBuffer(); 
        
        for (int i = stringArray.length - 1; i >= 0; i--) {
            updateString.append(stringArray[i]);
            if(i != 0) updateString.append(" ");
        }

        return updateString.toString();
    }

    public static void main(String[] args) {
        String example1 = "the sky is blue";
        String example2 = "  hello world  ";
        String example3 = "a good   example";

        System.out.println("\nUsing inbuilt functions: \n");
        System.out.println(reverseWords(example1));
        System.out.println(reverseWords(example2));
        System.out.println(reverseWords(example3));

        System.out.println("\n\n\nWithout inbuilt functions: \n");
        System.out.println(reverseWordsWithoutUsingInbuildMethods(example1));
        System.out.println(reverseWordsWithoutUsingInbuildMethods(example2));
        System.out.println(reverseWordsWithoutUsingInbuildMethods(example3));
    }
}
