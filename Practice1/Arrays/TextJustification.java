package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Must need to be practiced still not clear
 * 
 */

public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int index = 0;

        while(index < words.length){
            
            int count = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                
                if(count + 1 + words[last].length() > maxWidth) break;
                count += 1 + words[last].length();
                last++;

            }

            StringBuilder sb = new StringBuilder();
            int numberOfWords = last - index;
            int numberOfSpaces = maxWidth - count + (numberOfWords - 1);
            
            if(last == words.length || numberOfWords == 1){
                
                for (int i = index; i < last; i++) {

                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");

                }
                
                while (sb.length() < maxWidth) sb.append(" ");

            } else {

                int spacesBetweenWords = numberOfSpaces / (numberOfWords - 1);
                int extraSpaces = numberOfSpaces % (numberOfWords - 1);

                for (int i = index; i < last; i++) {
                    
                    sb.append(words[i]);

                    if (i < last - 1) {

                        int spaces = spacesBetweenWords + (i - index < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spaces; s++) sb.append(" ");

                    }

                }

            }

            result.add(sb.toString());
            index = last;

        }

        return result;
    }

    //practice
    // public static List<String> fullJustify(String[] words, int maxWidth) {
        
    // }

    public static void main(String[] args) {
        String wordsExample1[] = {"What","must","be","acknowledgment","shall","be"};
        int maxWidthExample1 = 16;
        
        String wordsExample2[] = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidthExample2 = 16;

        String wordsExample3[] = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidthExample3 = 20;

        System.out.println(fullJustify(wordsExample1, maxWidthExample1));
        System.out.println(fullJustify(wordsExample2, maxWidthExample2));
        System.out.println(fullJustify(wordsExample3, maxWidthExample3));
    }    
}
