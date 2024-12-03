class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> cm = new HashMap<>();

        for(char c: s.toCharArray()) {
            cm.put(c, cm.getOrDefault(c, 0)+1);
        }

        for(char c: t.toCharArray()){
            if(!cm.containsKey(c)) return false;

            cm.put(c, cm.get(c)-1);

            if(cm.get(c) < 0 ) return false;
        }
        return true;
    }
}
