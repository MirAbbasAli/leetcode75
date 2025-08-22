package array;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TargetRange {
    public int findFirstOccurrence(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while (l <= r){
            int m = l + (r - l)/2;
            if (nums[m] == target){
                res = m;
                r = m - 1;
            }
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return res;
    }
    public int findLastOccurrence(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while (l <= r){
            int m = l + (r - l)/2;
            if (nums[m] == target){
                res = m;
                l = m + 1;
            }
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return res;
    }
    public int[] range(int[] nums, int target){
        if (nums.length == 0) return new int[]{-1, -1};
       return new int[]{findFirstOccurrence(nums, target), findLastOccurrence(nums, target)};
    }

    public static void main(String[] args){
       List<List<Integer>> tests = List.of(
               List.of(5, 3, 7, 8, 8, 9),
               List.of(5, 3, 7, 8, 8, 9),
               List.of(),
               List.of(7,8,8,8,8)
       );
       List<Integer> targets = List.of(8, 0, 1, 8);
        IntStream.range(0, targets.size())
                .forEach(i -> {
                    TargetRange sol = new TargetRange();
                    int target = targets.get(i);
                    int[] nums = tests.get(i).stream().mapToInt(n->n).toArray();
                    int[] res = sol.range(nums, target);
                    System.out.println(Arrays.toString(res));
                });
    }
}
