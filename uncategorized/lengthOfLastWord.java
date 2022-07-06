class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        boolean word = false;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (word) {
                    return result;
                }
            } else {
                word = true;
                result++;
            }
        }
        return result;
    }
}