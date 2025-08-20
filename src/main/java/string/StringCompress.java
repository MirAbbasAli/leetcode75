package string;

public class StringCompress {
    public int compress(char[] chars) {
        int writeIdx = 0, count = 1, len = chars.length;

        for (int readIdx = 1; readIdx <= len; readIdx++){
            if (readIdx < len && chars[readIdx] == chars[readIdx - 1]){
                count++;
            } else {
                chars[writeIdx++] = chars[readIdx - 1];
                if (count > 1){
                    char[] nums = Integer.toString(count).toCharArray();
                    for (var num : nums){
                        chars[writeIdx++] = num;
                    }
                }
                count = 1;
            }
        }
        return writeIdx;
    }
    public static void main(String[] args){
        char[] test = {'a','a','b','b','c','c','c'};
        System.out.println(new StringCompress().compress(test));
        
    }
}
