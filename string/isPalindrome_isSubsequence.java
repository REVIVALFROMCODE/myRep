public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}


//Regex
public class Solution {
    public boolean isPalindrome(String s) {
        String[] sa = s.trim().toLowerCase().split("[^a-zA-Z0-9]+");
        StringBuilder sb = new StringBuilder();
        for(String v:sa) sb.append(v);
        s= sb.toString();
        if(s.equals("")) return true;
        int left = 0; int right=s.length()-1;
        System.out.println(s);
        while(left<right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }
}


//another two pointer simple problem: Input: s = "abc", t = "ahbgdc"
//Output: true
//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j++)) i++;
        }
        return i==s.length();
    }
    
}
