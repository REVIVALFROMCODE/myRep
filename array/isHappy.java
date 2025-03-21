/*

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
For example, the sequence starting with 19 is: 19 → 82 → 68 → 100 → 1

If a number is unhappy, it enters a small cycle like: 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
*/
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {//If the number reappears in the set, it means we're in a cycle
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {//if input is 19, second turn 1>0
            int digit = n % 10;//digit = 9, digit = 1
            n = n / 10;//n=1, n=0
            totalSum += digit * digit;//9*9, 1*1
        }
        return totalSum;//input 19, totalSum= 1^2 + 9^2 = 82
    }
}
