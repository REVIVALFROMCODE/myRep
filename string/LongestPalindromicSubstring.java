public class Solution {
    private class Segment{
        int start;
        int end;
        Segment(int i, int j){
            start=i;
            end=j;
        }
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //two cases of PS, "aba" and "bb"
            Segment seg1 = new Segment(0,0);
            Segment seg2 = new Segment(0,0);
            int len1 = expandAroundCenter(s, i, i, seg1);
            int len2 = expandAroundCenter(s, i, i + 1, seg2);
            if (len1 > end-start && len1>len2){
                start = seg1.start;
                end = seg1.end;
            }else if (len2 > end-start && len1<len2){
                start = seg2.start;
                end = seg2.end;
            }
            
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right, Segment seg) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        seg.start=left+1;
        seg.end=right-1;
        return right - left - 1;
    }
}

//Solution2 No need to use segment
public class Solution {
    public static String findLongestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                //how to deduce start and end from i and len?
                //given array 0,1,2,3 i=2, len=3(sub 1,2,3); end=i.next=i+len/2, start=i-len/2 or i-(len-1)/2
                //given array 0,1,2,3,4 i=2, len=4(sub 1,2,3,4); end=i+len/2, start=i-(len-1)/2
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
