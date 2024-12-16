/*
Input: ransomNote = "aa", magazine = "aab"
Output: true
*/

class Solution {//std
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> letter = new HashMap<>();
        //count
        for( char c : magazine.toCharArray()){
            letter.put(c, letter.getOrDefault(c, 0) + 1);
        }

        //Check
        for( char c : ransomNote.toCharArray()){
            if(!letter.containsKey(c) || letter.get(c) == 0){
                return false;
            }
            letter.put(c, letter.get(c) -1 );
        }
        return true;
    }
}

class Solution {//bucket
    public boolean canConstruct(String ransomNote, String magazine) {
        int letter[] = new int[26];

        //Count
        for(char c: magazine.toCharArray()){
            letter[c - 'a']++;
        }

        //Check
        for(char c: ransomNote.toCharArray()){
            if(letter[c-'a'] == 0) return false;
            letter[c-'a']--;
        }

        return true;
    }
}
