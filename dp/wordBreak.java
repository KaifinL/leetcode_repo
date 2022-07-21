/*
passed the tests. This problem is related to dp. Some observations are needed.
First, we will need to come up with a back tracking version, to see the patterns 
of the passed strings. We then notice that starting with each letter, we can determine
whether the current substring has a match in wordDict. However, having a substring 
in wordDict doesn't guareentee that the target string must start with the current indx.
That's the reason why we are using dp.

A more specific explanation is here:https://www.youtube.com/watch?v=Sx9NNgInc3A
*/



class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean []wb = new boolean[s.length()+1];
        wb[s.length()] = true;
        for (int i = s.length()-1; i>=0; i--) {
            boolean flag = false;
            // see if there is such word in wordDict that matches
            // the substring started with s.i
            for (String curr: wordDict) {
                int length = curr.length();
                if (i+length <= s.length() && s.substring(i, i+length).equals(curr) && wb[i+length]) {
                    flag = true;
                }
            }
            wb[i] = flag;
        }
        return wb[0];
    }
}