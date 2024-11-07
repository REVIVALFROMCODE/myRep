class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n =words.length;
        int index=0;

        while(index<n){
            int totalChars = words[index].length();
            int last=index+1;

            while(last<n){//find each line's last index of string
                if(totalChars+1+words[last].length()>maxWidth) break;
                totalChars+=1+words[last].length(); //+space
                last++;
            }
            StringBuilder sb=new StringBuilder();
            int wordCount=last-index;
            int spaceCount=maxWidth-totalChars;

            if(last==n || wordCount==1){//left justification
                for(int i=index; i<last; i++){
                    sb.append(words[i]);
                    if(i<last-1) sb.append(' '); // insert space except last one
                }
                while(sb.length()<maxWidth) sb.append(' ');//append space until equal to maxWidth
            }else{//caculate space, make space insert evenely between words
                int spaces = spaceCount / (wordCount-1); //wordCount-1 is number of margin
                int extraSpaces = spaceCount % (wordCount -1);
                for(int i=index; i<last; i++){//for each word
                    sb.append(words[i]);
                    if(i<last-1){//adding space except for last word
                        for(int j=0; j<=(spaces+ (i-index < extraSpaces? 1:0));j++){//e.g. we have three margin and two extra spaces, we want to add it from left, with spaces base two, distribution of spaces should be 3,3,2
                            sb.append(' ');
                        }
                    }
                }
            }
            result.add(sb.toString());
            index=last;

        }
        return result;
    }

}
