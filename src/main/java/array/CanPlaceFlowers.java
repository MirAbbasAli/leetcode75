package array;

import java.util.List;
import java.util.stream.IntStream;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length, flower = 0;
        for (int i = 0; i < len; i++){
            if (flowerbed[i] == 1) continue;
            boolean canPlace = true;
            if (i > 0 && flowerbed[i - 1] == 1) canPlace = false;
            if (i < len - 1 && flowerbed[i + 1] == 1) canPlace = false;
            if (canPlace){
                flowerbed[i] = 1;
                flower++;
            }
        }
        return flower >= n;
    }

    public static void main(String[] args){
        List<List<Integer>> tests = List.of(
                List.of(1, 0, 0, 0, 1),
                List.of(1, 0, 0, 0, 1),
                List.of(1, 0, 0, 0, 0, 1)
        );
        List<Integer> test2 = List.of(1, 2, 2);

        IntStream.range(0, test2.size())
                .forEach(val ->
                    System.out.println(
                            new CanPlaceFlowers().canPlaceFlowers(
                                tests.get(val).stream().mapToInt(n->n).toArray(),
                                test2.get(val)
                            )
                    )
                );
    }
}
