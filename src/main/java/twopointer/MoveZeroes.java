package twopointer;

import java.util.Arrays;
import java.util.List;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroIdx = -1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0 && zeroIdx == -1){
                zeroIdx = i;
            }
            else if (nums[i] != 0 && zeroIdx != -1){
                nums[zeroIdx++] = nums[i];
                nums[i] = 0;
            }
        }
    }
    public static void main(String[] args){
        List<List<Integer>> tests= List.of(
                List.of(0, 1, 0, 3, 12),
                List.of(1, 3, 0, 5, 0, 0, 7),
                List.of(1, 3, 0, 5, 6, 0, 7, 8, 9, 0, 4)
        );

        tests.forEach(test->{
            MoveZeroes sol = new MoveZeroes();
            int[] nums = test.stream().mapToInt(n->n).toArray();
            sol.moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        });

    }
}
