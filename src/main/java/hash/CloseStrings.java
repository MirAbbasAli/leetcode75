package hash;

import java.util.Arrays;
import java.util.List;


public class CloseStrings {
    public boolean closeStrings(String word1, String word2){
        if (word1.length() != word2.length()) return false;

        int[] set1 = new int[26];
        int[] set2 = new int[26];

        for (int i = 0; i < word1.length(); i++){
            set1[word1.charAt(i) - 'a']++;
            set2[word2.charAt(i) - 'a']++;
        }

        // set1, set2 contains same character
        for (int i = 0; i < 26; i++){
            if ((set1[i] == 0 && set2[i] != 0) || (set1[i] != 0 && set2[i] == 0)) return false;
        }

        Arrays.sort(set1);
        Arrays.sort(set2);

        return Arrays.equals(set1, set2);

    }
    public static void main(String[] args){
        List<List<String>> tests = List.of(
                List.of("abc", "bca"),
                List.of("a", "aa"),
                List.of("cabbba", "abbccc"),
                List.of("abbzzca", "babzzcz"),
                List.of("uau", "ssx")
        );
        tests.forEach(test ->
            System.out.println(new CloseStrings().closeStrings(test.get(0), test.get(1)))
        );
    }
}
