package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for (int[] row : grid) {
            // Check for col
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (row[k] != grid[k][j]) break;
                    if (k == n - 1) count++;
                }
            }
        }
        return count;
    }

    public int equalPairsFaster(int[][] grid){
        Map<String, Integer> rowMap = new HashMap<>();

        for (int[]row : grid){
            String rowStr = Arrays.toString(row);
            rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
        }
        int n = grid.length, count = 0;
        // Check the count of column in the grid
        for (int i = 0; i < n; i++){
            int[] col = new int[n];
            for (int j = 0; j < n; j++){
                col[j] = grid[j][i];
            }
            String colStr = Arrays.toString(col);
            count += rowMap.getOrDefault(colStr, 0);
        }
        return count;
    }

    public static void main(String[] args){
        int[][] test1 = {{3,2,1},{1,7,6},{2,7,7}};
        int[][] test2 = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};

        EqualPairs sol = new EqualPairs();
        System.out.println(sol.equalPairsFaster(test1));
        System.out.println(sol.equalPairsFaster(test2));

    }
}
