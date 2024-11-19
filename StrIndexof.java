class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            /*
            Implementation I
            public boolean startsWith(String prefix, int toffset)
            Tests if the substring of this string beginning at the specified index starts with the specified prefix.
            */
            if (haystack.startsWith(needle, i)) return i;
            /*
            Implementation II raw (The for loop below actually implement startsWith manually)
            int j; 
            for (j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                break; 
                } 
            } 
            if (j == needleLength) return i;
            */
            
            /*
            Implementation III According to API document, startsWith is delegation of this.substring(toffset).startsWith(prefix).
            if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
            */
            //delegation chain is Indexof(subStr)->startsWith(prefix)->substring(index)->charAt(index)
        }
        return -1;
    }
}
/*
Given two strings, haystack and needle, the function returns the index of the first occurrence of needle in haystack. 
If needle is not found, it returns -1. If needle is an empty string, the function returns 0.
*/
