class Solution {
    public int lengthOfLastWord(String s) {
        //Remove any trailing spaces from the string.
        //s=s.trim();
        s=trim(s);
        for(int i =s.length() -1 ; i>=0; i--){
            if(s.charAt(i) == ' '){
                return s.length() - i -1 ;
            }
        }
        return s.length();
    }

    String trim(String s){
        if(s==null || s.length() == 0) return s;
        int start = 0; int end =s.length() -1;

        while(start<=end && s.charAt(start)==' '){
            start++;
        }

        while(end>=start && s.charAt(end)==' '){
            end--;
        }

        s = s.substring(start,end+1);

        return s;
    }
}

/*
    String word[] = s.split(" ");

    return word[word.length-1].length();
 */
