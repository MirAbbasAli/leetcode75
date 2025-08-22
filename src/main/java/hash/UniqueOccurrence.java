package hash;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueOccurrence {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        HashSet<Long> seen = new HashSet<>();
        for (Long count: freqMap.values()){
            if (!seen.add(count)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        List<List<Integer>> tests = List.of(
                List.of(1,2,2,1,1,3), List.of(1, 2), List.of(-3,0,1,-3,1,1,1,-3,10,0)
        );
        tests.forEach(test -> System.out.println(new UniqueOccurrence().uniqueOccurrences(test.stream().mapToInt(n->n).toArray())));
    }
}
