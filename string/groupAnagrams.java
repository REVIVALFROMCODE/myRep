/*
Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        //sort each string, no need to save sorted string
        for(String str:strs){
            String sortStr=sort(str);
            if (!map.containsKey(sortStr)){
                map.put(sortStr, new ArrayList<>());
            }
            map.get(sortStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
    String sort(String s){
        char[] c = s.toCharArray();
        sort(0,c.length-1,c);
        return new String(c);
    }
    void sort(int lo, int hi, char[] c){
        if(lo>=hi) return;
        int j = partition(lo,hi,c);
        sort(lo,j-1,c);
        sort(j+1,hi,c);
    }
    int partition(int lo, int hi, char[] c){
        int i=lo;
        int j=hi+1;
        int v=c[lo];
        while(true){
            while(c[++i]<=v) if(i==hi) break;
            while(c[--j]>=v) if(j==lo) break;
            if(i>=j) break;
            exch(i,j,c);
        }
        exch(j,lo,c);
        return j;
    }
    void exch(int i,int j,char[] c){
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
}
