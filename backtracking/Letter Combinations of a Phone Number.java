/*
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/

/*
start from first digit, we retrieve string according to final map.

call recursively with i++ to next digit, pass StringBuilder to store intermittent result.

once i reach to length of digits, we store valid result in ArrayList.

for each recursive call, we delete added digit after recursive call returned. That's how backstracking works.

Ds: Input string digits/params
StringBuilder for intermittent result
List<String> for valid result
*/
public class Solution {
    private static final String[] KEYPAD = {
            "",    "",    "abc",  "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String params) {
        List<String> resArray = new ArrayList<>();
        if (params == null || params.length() == 0) {
            return resArray;
        }
        backtrack(resArray, new StringBuilder(), params, 0);
        return resArray;
    }

    private void backtrack(List<String> resArray, StringBuilder sb, String params, int i) {
        if (i == params.length()) {
            resArray.add(sb.toString());
            return;
        }
        String letters = KEYPAD[params.charAt(i) - '0'];
        for (char letter : letters.toCharArray()) {
            sb.append(letter);
            backtrack(resArray, sb, params, i + 1);
            //backtracking step
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
