package twopointer;

import java.util.List;
import java.util.stream.IntStream;

public class MaxNumberKSum {
    public int maxOperations(int[] nums, int k) {
        return -1;

    }
    public static void main(String[] args){
        List<List<Integer>> tests = List.of(
                List.of(1, 2, 3, 4), List.of(3, 1, 3, 4, 3)
        );
        int[] k = {5, 6};

        IntStream.range(0,2)
                .forEach(i -> System.out.println(new MaxNumberKSum().maxOperations(
                        tests.get(i).stream().mapToInt(n->n).toArray(),
                        k[i]
                )));
    }
}
