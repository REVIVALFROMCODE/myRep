/*
Input:
3 2 1 
1 7 6
2 7 7
Output:
cnt=1, as 2 7 7 exists
*/
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        int count = 0;

        // Store each row in the HashMap with its frequency
        for (int[] row : grid) {
            String rowString = arrayToString(row);
            rowMap.put(rowString, rowMap.getOrDefault(rowString, 0) + 1);
        }

        // Compare each column with the rows in the HashMap
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String colString = arrayToString(col);
            count += rowMap.getOrDefault(colString, 0);
        }

        return count;
    }

    // Helper method to convert an array to a string
    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(",");
        }
        return sb.toString();
    }
}
