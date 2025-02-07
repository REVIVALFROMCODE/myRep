class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
              //board[i][j] is a digit 1-9 or '.'
                if (c != '.') {
                    int index = c - '0' - 1;
                    //Each row must contain the digits 1-9 without repetition.
                    if(rows[i][index] == 1) return false;
                    rows[i][index]++;
                    //Each column must contain the digits 1-9 without repetition.
                    if(columns[j][index] == 1) return false;
                    columns[j][index]++;
                    //Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
                    if(subboxes[i / 3][j / 3][index] == 1) return false;
                    subboxes[i / 3][j / 3][index]++;
                }
            }
        }
        return true;
    }
}
