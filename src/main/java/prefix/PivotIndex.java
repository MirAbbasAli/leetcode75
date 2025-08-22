package prefix;

import java.util.Arrays;
import java.util.List;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0, rightSum;

        for (int i = 0; i < n; i++){
            rightSum = sum - leftSum - nums[i];

            if (leftSum == rightSum) return i;

            leftSum += nums[i];
        }
       return -1;
    }

    public static void main(String[] args){
        List<List<Integer>> tests = List.of(
                List.of(1,7,3,6,5,6), List.of(1,2,3), List.of(2,1,-1)
        );

        tests.forEach(test -> System.out.println(new PivotIndex().pivotIndex(test.stream().mapToInt(n->n).toArray())));
    }
}
