/*
Input: strs = ["flower","flow","flight"]
Output: "fl"
GOAL: Find common prefix in group of Strings. Note: A valid common prefix is those strings must start with that subString. 
        "cc" is not valid for "acc", because cc is not "prefix".
ALGO: Iterate from second String, save first string as pre, 
        Method indexOf(String) Returns the index within this string of the first occurrence of the specified substring
        specified substring.
        check by indexOf(pre) and start while loop. Shrink pre as long as indexOf(pre) is zero.  
*/
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
/*example of implement indexOf*/
public static int indexOfLatin1Unsafe(byte[] src, int srcCount, byte[] tgt, int tgtCount, int fromIndex) {
        assert fromIndex >= 0;
        assert tgtCount > 0;
        assert tgtCount <= tgt.length;
        assert srcCount >= tgtCount;
        char first = (char)(tgt[0] & 0xff);
        int max = (srcCount - tgtCount);
        for (int i = fromIndex; i <= max; i++) {
            // Look for first character.
            if (getChar(src, i) != first) {//continue
                while (++i <= max && getChar(src, i) != first);
            }
            // Found first character, now look at the rest of v2
            if (i <= max) {
                int j = i + 1;
                int end = j + tgtCount - 1;
                for (int k = 1;
                     j < end && getChar(src, j) == (tgt[k] & 0xff);
                     j++, k++);//increment k and j
                if (j == end) {//result is only valid when j==end
                    // Found whole string.
                    return i;
                }
            }
        }
        return -1;
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
