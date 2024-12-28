//Input: "bvbf"
//return: 3
//Solution 1: take n^2 time, because: once (i,j) fail, we increment i, but we have to check whole sub string (i,j), which take redundant time.
class Solution {
    static boolean[] m = new boolean[256];
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2) return s.length();
        int max = -1;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(exam(s.substring(i,j))) max=Math.max((j-i),max);
                else i++;
            }
        }
        return max;
    }
    private boolean exam(String s){
        for (int i = 0; i < m.length; i++) {
            m[i] = false;
        }
        for(int i=0;i<s.length();i++){
            if(m[s.charAt(i)]==true){
                return false;
            } 
            m[s.charAt(i)]=true;
        }
        return true;
    }
}

//Solution 2, e.g. "'Start' ... 'dup' ... 'dup'", once we reach dup, we increment start, check if it is the 'dup' we are looking for, we check character rather whole string until we find the 'dup' and start a new round.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] m = new boolean[256];
        int start=0;
        int current=0;
        int max=0;
        for(int i=0;i<s.length();i++){//end i
            if(m[s.charAt(i)]){
                max=Math.max(current,max);
                while(m[s.charAt(i)]){
                    m[s.charAt(start)]=false;
                    start++;
                    current--;
                }
            }
          //we can't put else{} here, even if there is only two cases here(true or false)
          //consider "aab" 012, when i=1, start=1, i is waiting start find dup 'a' then we need m[i]=true after start=i. if we put else m[i]=true will not happen.
            m[s.charAt(i)]=true;
            current++;
        }
        return Math.max(current,max);
    }
}
