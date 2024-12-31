public class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int pop = x % 10; // Extract the last digit
            x /= 10; // Remove the last digit

            // Check for overflow before multiplying by 10
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            result = result * 10 + pop; // Add the digit to the result
        }

        return result;
    }
}
