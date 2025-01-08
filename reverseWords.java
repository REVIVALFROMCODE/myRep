class Solution {
    public String reverseWords(String s) {
// \s matches any whitespace character 
// + matches the previous token between one and unlimited times, as many times as possible
        String words[]=s.trim().split("\s+");

        StringBuilder sb = new StringBuilder();

        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if(i==0) break;
            sb.append(" ");
        }

        return sb.toString();
    }
}

/*
Input: s = "a good   example"
Output: "example good a"
*/

//Solution2, regex pattern is slow
class Solution {
    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int end = s.length() - 1;

        while (end >= 0) {
            while (end >= 0 && s.charAt(end) == ' ') end--;
            if (end < 0) break;
            int start = end;
            while (start-1 >= 0 && s.charAt(start-1) != ' ') start--;
            res.append(s.substring(start, end + 1));
            
            res.append(" ");
            end = start - 1;
        }
        return res.toString().trim();
    }
}
