package array;

import java.util.List;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (var num : nums){
            if (num <= first){
                first = num;
            } else if (num <= second){
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        List<List<Integer>> tests = List.of(
                List.of(1,2,3,4,5),
                List.of(5,4,3,2,1),
                List.of(2,1,5,0,4,6),
                List.of(20,100,10,12,5,13),
                List.of(1,5,0,4,1,3)
        );
        tests.forEach(test->{
            IncreasingTripletSubsequence sol = new IncreasingTripletSubsequence();
            int[] nums = test.stream().mapToInt(n->n).toArray();
            System.out.println(sol.increasingTriplet(nums));
        });
    }
}
