

class Solution {
    public int myAtoi(String s) {
        
        //Algorithm 1.skip white spaces
        //2.determine sign
        //3.convert digit util first non-digit
        //4.check bound
        s = s.trim();
        if (s.length() == 0) return 0;
        int i = 0;
        char sign = s.charAt(i);
        int signInt = 1;
        if (sign == '+' || sign == '-') {
            signInt = sign == '+' ? 1 : -1;
            i++;
        } else {
            //nothing
        }
        long res = 0;
        for (; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) break;

            res = res * 10 + (s.charAt(i) - '0');

            if (res * signInt > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (res * signInt < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

        }
        return (int)res * signInt;
    }
}
