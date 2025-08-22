package slidingwindow;

import java.util.List;
import java.util.stream.IntStream;

public class MaxAverageSubarr {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (r < n){
            sum += nums[r];
            if (l < n && (r - l + 1) == k){
                max = Math.max(max, sum);
                sum -= nums[l++];
            }
            r++;
        }
        return (double) max / k;
    }

    public static void main(String[] args){
        List<List<Integer>> tests = List.of(
                List.of(1,12,-5,-6,50,3),
                List.of(5)
        );
        List<Integer> k = List.of(4, 1);

        IntStream.range(0, k.size())
                .forEach(i->{
                    MaxAverageSubarr sol = new MaxAverageSubarr();
                    int[] nums = tests.get(i).stream().mapToInt(n->n).toArray();
                    System.out.println(sol.findMaxAverage(nums, k.get(i)));
                });
    }
}
