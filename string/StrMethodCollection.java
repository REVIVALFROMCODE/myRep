package org.example;

//delegation chain is Indexof(subStr)->startsWith(prefix)->substring(index)->charAt(index)
public class StrMethodCollection {

    public boolean startWith(String haystack, String needle, int start) {
        return startWith(subString(haystack, start), needle);
    }

    public static boolean startWith(String haystack, String needle) {
        for (int j = 0; j < needle.length(); j++) {
            if (charAt(haystack, j) != charAt(needle, j)) return false;
        }
        return true;
    }

    public static String subString(String s, int index) {
        if (s == null || index > s.length() - 1) return null;

        char[] res = new char[s.length() - index];
        for (int i = index; i < s.length(); i++) {
            res[i-index] = charAt(s, i);
        }
        return new String(res);
    }
    public static String subString(String s, int start, int end) {
        char[] res= new char[end-start];
        for(int i=start;i<end;i++){
            res[i-start] = charAt(s,i);
        }
        return new String(res);
    }

    public static char charAt(String s, int index) {
        try {
            return s.toCharArray()[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }

    }
}
