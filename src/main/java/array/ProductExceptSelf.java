package array;

import java.util.Arrays;
import java.util.List;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        /*
        1 2 3 4 get the product
        1 2 6 24
        24 24 12 4 (prefix[i]/nums[i] * suffix[i]/nums[i]
        24 12 8 6
         -1  1 0 -3 3
         -1 -1 0 0 0
          0  0 0 -9 3
          0  0 9 0 0
          nums[0] = suffix[1], nums[-1] = prefix[-2]
         */
        // Create the prefix, suffix product array
        /*
        int len = nums.length;

        if (len == 1) return nums;

        int[] prefix = new int[len];
        int[] suffix = new int[len];
        for (int idx = 0, revIdx = len - 1; idx < len; idx++, revIdx--){
            if (idx == 0 && revIdx == len - 1){
                prefix[idx] = nums[idx];
                suffix[revIdx] = nums[revIdx];
            } else {
                prefix[idx] = nums[idx] * prefix[idx - 1];
                suffix[revIdx] = nums[revIdx] * suffix[revIdx + 1];
            }
        }

        nums[0] = suffix[1];
        nums[len - 1] = prefix[len - 2];

        for (int i = 1; i < len - 1; i++){
            nums[i] = prefix[i - 1] * suffix[i + 1];
        }
        return nums;

         */
        // Optimized approach
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        // 1 1 2 6
        for (int i = 1; i < n; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--){
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }
    public static void main(String[] args){
        List<List<Integer>> tests = List.of(
                List.of(1, 2, 3, 4),
                List.of(-1, 1, 0, -3, 3)
        );

        tests.forEach(test -> {
            int[] nums = test.stream().mapToInt(n->n).toArray();
            ProductExceptSelf sol = new ProductExceptSelf();
            int[] output = sol.productExceptSelf(nums);
            System.out.println(Arrays.toString(output));
        });
    }
}
