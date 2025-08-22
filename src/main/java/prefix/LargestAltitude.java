package prefix;

import java.util.List;

public class LargestAltitude {
    public int largestAltitude(int[] gain) {
        int maxHeight = 0;
        int height = 0;
        for (int alt : gain){
            height += alt;
            maxHeight = Math.max(height, maxHeight);
        }
        return maxHeight;
    }
    public static void main(String[] args){
        List<List<Integer>> tests = List.of(
                List.of(-5,1,5,0,-7), List.of(-4,-3,-2,-1,4,3,2)
        );
        tests.forEach(test -> System.out.println(new LargestAltitude().largestAltitude(test.stream().mapToInt(n->n).toArray())));
    }
}
