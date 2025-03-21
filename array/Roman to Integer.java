/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? romanMap.get(s.charAt(i + 1)) : 0;

            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}

//Solution 2 backward order
class Solution{
	private int getRoman(char c){
		switch(c){
		case 'I':return 1;
		case 'V':return 5;
		case 'X':return 10;
		case 'L':return 50;
		case 'C':return 100;
		case 'D':return 500;
		case 'M':return 1000;
		default: return 0;
		}
	}

	public int romanToInt(String s){
		int sum=0;
		int previous=0;

		for(int i=s.length()-1; i>=0; i--){
			int rv=getRoman(s.charAt(i));
			if(rv<previous){
				sum-=rv;
			}else{
				sum+=rv;
				previous=rv;
			}
		}
		return sum;
	}
}
