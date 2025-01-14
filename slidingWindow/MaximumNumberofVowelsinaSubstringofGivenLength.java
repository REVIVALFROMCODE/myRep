/*
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
*/

class Solution {
    // Function to check if a character is a vowel
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public int maxVowels(String s, int k) {

        int maxVowels = 0;
        int currentVowels = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }

        maxVowels = currentVowels;
        int i = 0, j = k - 1;
        // Slide the window over the rest of the string
        while (true) {

            if (isVowel(s.charAt(i))) {
                currentVowels--;
            }
            i++;
            j++;
            if (j == s.length())
                break;
            if (isVowel(s.charAt(j))) {
                currentVowels++;
            }

            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}


/*Solution II*/
/*
ALGO: map 'a' - 'a' ~ 'z' - 'a' with zero except voewls with one. Which takes O(1) time to check vowel. Fixed sliding window until ends.
DS: a bit map like.
*/
class Solution {
    static int[] vowel = new int['z' - 'a' + 1];
    
    static {
        for (int i = 'a'; i <= 'z'; i++) vowel[i - 'a'] = 0;
        
        vowel['a' - 'a'] = 1;
        vowel['e' - 'a'] = 1;
        vowel['i' - 'a'] = 1;
        vowel['o' - 'a'] = 1;
        vowel['u' - 'a'] = 1;

      //for (int i = 0; i < 500; i++) maxVowels("a", 1); JIT optimization
    }

    public static int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int maxVowels = 0;
        
        // Calculate initial number of vowels in the first window
        for (int i = 0; i < k; i++) {
            maxVowels += vowel[chars[i] - 'a'];
        }

        int currentVowels = maxVowels;
        for (int i = k; i < s.length(); i++) {
            currentVowels += vowel[chars[i] - 'a'] - vowel[chars[i - k] - 'a'];
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}
