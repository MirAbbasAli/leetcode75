package string;

import java.util.List;

public class MergeStringAlternatively {
    public String mergeAlternately(String word1, String word2) {
        int lenOne = word1.length(), lenTwo = word2.length();
        StringBuilder merged = new StringBuilder();
        int i = 0;
        while (i < lenOne && i < lenTwo){
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
            i++;
        }
        while (i < lenOne){
            merged.append(word1.charAt(i));
            i++;
        }
        while (i < lenTwo){
            merged.append(word2.charAt(i));
            i++;
        }
        return new String(merged);
    }
    public static void main(String[] args){
        List<List<String>> tests = List.of(
                List.of("abc", "pqr"),
                List.of("ab", "pqrs"),
                List.of("abcd", "pq")
        );

        tests.forEach(test -> System.out.println(new MergeStringAlternatively().mergeAlternately(test.get(0), test.get(1))));
    }
}
