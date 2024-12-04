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
