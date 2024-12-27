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
