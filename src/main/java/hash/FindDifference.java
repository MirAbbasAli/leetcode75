package hash;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDifference {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        return Arrays.asList(
                set1.stream().toList(),
                set2.stream().toList());

    }
    private static int[] mapToArray(List<Integer> arr){
        return arr.stream().mapToInt(n->n).toArray();
    }
    public static void main(String[] args){
        List<List<Integer>>num1 = List.of(
                List.of(1, 2, 3), List.of(1,2,3,3)
        );
        List<List<Integer>> num2 = List.of(
                List.of(2,4,6), List.of(1, 1, 2,2)
        );
        IntStream.range(0, num1.size())
                .forEach(i ->{
                    FindDifference sol = new FindDifference();
                    System.out.println(sol.findDifference(
                            mapToArray(num1.get(i)),
                            mapToArray(num2.get(i))));
                });
    }
}
