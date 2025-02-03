/*
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

sorted in increasing order, 0,1,3,5,6 , consider '1', there are n-i = 5-1 = 4(behind) papers appear >= 1 (num[1])'s citation.

4 papers 1 time
3 papers 3 times
2 papers 5 times.

return 3
*/
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }
}
