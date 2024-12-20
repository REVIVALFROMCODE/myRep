class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs[0].isEmpty()) return "";

        String pre= strs[0];//1st string 'flower'

        for(int i =1; i<strs.length; i++){ //iterate array of String
            while(strs[i].indexOf(pre)!=0){
                /*      
                        
                        only accept common prefix return ==0, return >0 is not acceptable, 'contain' not equal to 'start with', see reason below
                        ["c","acc","ccc"] suppose to return "" rather "c", because acc not start with 'c'
                */
                pre=pre.substring(0,pre.length()-1);//shorten prefix
                if (pre.isEmpty()) return "";
            }
        }
        return pre;
    }
}

/*
For the input ["flower", "flow", "flight"]:

Start with pre = "flower".

Compare with "flow", adjust pre to "flow".

Compare with "flight", adjust pre to "fl".

Final output is "fl".

For the input ["c", "acc", "ccc"]:

Start with pre = "c".

Compare with "acc", adjust pre to "" since "acc" does not start with "c".

Final output is "".
*/
