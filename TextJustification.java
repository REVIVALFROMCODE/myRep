class Solution {
    /*
    Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    Output:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
    */
        public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {// for each string
            int totalChars = words[index].length(); // initiate accumulate with length of current string
            int last = index + 1; // index of last, start from next string

            while (last < n) {// find last index can be inserted in one line
                if (totalChars + 1 + words[last].length() > maxWidth) break; // calculate length
                totalChars += 1 + words[last].length();
                last++;
            }//after this loop, we remain last and total.

            StringBuilder sb = new StringBuilder();
            int wordCount = last - index;// with minimal value: one
            int spaceCount = maxWidth - totalChars;

            //build String
            //case one: only one word left
            //case two: multiple words
            if (last == n || wordCount == 1) {//last line
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {//normally, make sure space inserted evenly
                //e.g. wordCount-1 of sections to insert spaces
                int spaces = spaceCount / (wordCount - 1);// divide: evenly spaces
                int extraSpaces = spaceCount % (wordCount - 1);// remainder: left spaces
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + (i - index < extraSpaces ? 1 : 0)); j++) sb.append(' ');
                    }
                }
            }
            result.add(sb.toString());
            index = last;// keep going
        }
        return result;
    }




public class Solution {
    public static void main(String[] args) {
        List<String> res = new Solution().fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);
        System.out.println(res);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {//each round of for , we build a formated String
            int charSum = words[i].length();
            int wordCount = 1;
            int startIndex = i;
            //+1 for avoid charSum equal width without spaces
            while (i + 1 < n && charSum + words[i + 1].length() + 1 <= maxWidth) {
                charSum = charSum + words[++i].length() + 1;
                wordCount++;
            }
            int endIndex = i;

            StringBuilder sb = new StringBuilder();
            int spaceCount = maxWidth - charSum;
            //once words out of used, we in 'if'
            //e.g. "shall be        "
            //in 'else', above string misformat to "shall         be"
            if (i == n - 1 || wordCount == 1) {
                sb.append(words[startIndex]);
                //<
                for (int j = startIndex + 1; j <= endIndex; j++) {
                    sb.append(' ').append(words[j]);
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {
                int spaces = spaceCount / (wordCount - 1);
                int extraSpaces = spaceCount % (wordCount - 1);
                for (int j = startIndex; j <= endIndex; j++) {
                    sb.append(words[j]);
                    //two cases: 1.not the last one(insert word and corresponding spaces) 2.last one(insert nothing but word)
                    if (j != endIndex) {
                        //two cases here, remain extraSpaces(insert spaces+1), extraSpaces has used up(insert space)
                        //use <=, because we have remained at least 1 space
                        for (int k = 0; k <= (spaces + (j - startIndex < extraSpaces ? 1 : 0)); k++) sb.append(' ');
                    }
                }

            }
            res.add(sb.toString());

        }
        return res;
    }
}
