package string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseVowels {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int len = s.length();
        char[] alter = s.toCharArray();
        for (int l = 0, r = len - 1; l < r; l++, r--){
            while (l < r && !vowels.contains(alter[l])) l++;
            while (l < r && !vowels.contains(alter[r])) r--;
            if (l < r) {
                char temp = alter[l];
                alter[l] = alter[r];
                alter[r] = temp;
            }
        }
        return new String(alter);
    }
    public static void main(String[] args){
        List<String> tests = List.of("IceCreAm", "leetcode");
        tests.forEach(test -> System.out.println(new ReverseVowels().reverseVowels(test)));
    }
}
