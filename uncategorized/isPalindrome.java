class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder letter_s = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if ((curr >= 97 && curr <= 122) || (curr >= 48 && curr <= 57)) {
                letter_s.append(curr);
            } else if (curr >= 65 && curr <= 90) {
                letter_s.append((char)(curr+32));
            }
        }
        int first = 0;
        int second = letter_s.length()-1;
        while (first < second) {
            if (letter_s.charAt(first)!= letter_s.charAt(second)) {
                return false;
            } 
            first++;
            second--;
        }
        return true;
    }
}