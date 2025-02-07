/*
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Hierarchical simulation from four directions. From up, bottom, left, right. Decrease relevant one of them each round.
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> res = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1;
        int u = 0, d = matrix.length - 1;
        //given 3*3 matrix
        while(u <= d && l <= r){
            //(0,0) (0,1) (0,2)
            //2nd round, (1,1)
            for(int j = l; u <= d && j <= r; j++) {
                res.add(matrix[u][j]);
            }
            //Decrease up direction
            u++;
            //(1,2) (2,2)
            for(int i = u; l <= r && i <= d; i++){
                res.add(matrix[i][r]);
            }
            //Decrease right direction
            r--;
            //(2,1) (2,0)
            for(int j = r; u <= d && j >= l; j--) {
                res.add(matrix[d][j]);
            }
            //Decrease bottom direction
            d--;
            //(1,0)
            for(int i = d; l <= r && i >= u; i--) {
                res.add(matrix[i][l]);
            }
            //Decrease left direction
            l++;
        }
        return res;
    }
}
