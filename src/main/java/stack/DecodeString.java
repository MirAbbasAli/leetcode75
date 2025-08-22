package stack;

import java.util.List;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            else if (c == '['){
                numStack.push(num);
                stringStack.push(currStr.toString());
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']'){
                int n = numStack.pop();
                StringBuilder prev = new StringBuilder(stringStack.pop());
                for (int i = 0; i < n; i++){
                    prev.append(currStr);
                }
                currStr = prev;
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }

    public static void main(String[] args){
        List<String> tests = List.of("3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "abc3[cd]xyz");
        tests.forEach(test -> System.out.println(new DecodeString().decodeString(test)));
    }
}
