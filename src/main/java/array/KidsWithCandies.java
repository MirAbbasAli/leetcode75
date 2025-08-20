package array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = -1;
        for (int candy : candies) maxCandies = Math.max(maxCandies, candy);
        List<Boolean> ans = new ArrayList<>();
        for (int candy : candies) {
            ans.add(candy + extraCandies >= maxCandies);
        }
        return ans;
    }
}
