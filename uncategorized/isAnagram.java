

/*
better and cleaner code from discussion area.
https://leetcode.com/problems/valid-anagram/discuss/66484/Accepted-Java-O(n)-solution-in-5-lines
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}

/*
this passed the tests, but kinda slow. We can just use an array with 26 positions.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        HashMap<Character, Integer> mapping = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            mapping.put(s.charAt(i), mapping.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            int curr = mapping.getOrDefault(t.charAt(i), 0);
            if (curr == 0) {
                return false;
            }
            mapping.put(t.charAt(i), curr-1);
        }
        return true;
    }
}