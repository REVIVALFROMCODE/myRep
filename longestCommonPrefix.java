class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs[0].isEmpty()) return "";

        String pre= strs[0];//1st string 'flower'

        for(int i =1; i<strs.length; i++){ //iterate other strings 'flow', 'flight'
            while(strs[i].indexOf(pre)!=0){//only 1st string is common prefix return 0, return >0 is not acceptable , see below
            //["c","acc","ccc"] suppose to return "" rather "c", because acc not start with 'c'
                pre=pre.substring(0,pre.length()-1);//shorten prefix
                if (pre.isEmpty()) return "";
            }
        }
        return pre;
    }
}
