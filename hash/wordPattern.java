class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");

        if(pattern.length() != words.length) return false;

        HashMap<Character, String> ps = new HashMap<>();
        HashMap<String, Character> sp = new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String w = words[i];

            if(ps.containsKey(c)){
                if(!ps.get(c).equals(w)) return false;
            }else{
                ps.put(c, w);
            }

            if(sp.containsKey(w)){
                if(sp.get(w) != c) return false;
            }else{
                sp.put(w, c);
            }
        }
        return true;
    }
}
