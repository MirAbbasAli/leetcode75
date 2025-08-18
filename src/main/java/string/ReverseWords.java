package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords {
    public String reverseWords(String s) {
        List<String> wordList = Arrays.stream(s.split(" ")).filter(word -> !word.isBlank()).collect(Collectors.toList());
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
    public static void main(String[] args){
        List<String> tests = List.of("the sky is blue", "  hello world  ", "a good   example");
        tests.forEach(test -> System.out.println(new ReverseWords().reverseWords(test)));
    }
}
