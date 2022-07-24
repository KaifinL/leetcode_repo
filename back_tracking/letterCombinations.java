class Solution {

    // mapping a single digit with the corresponding letters
    private char[] digit_to_letter(char digit) {
        // less than or equal to '6'
        char []result;
        if (digit <= '6') {
            result = new char[3];
            char curr = (char) (3*(Character.getNumericValue(digit) - 2)+97);
            result[0] = curr;
            result[1] = (char) (curr+1);
            result[2] = (char) (curr+2);
            return result;
        } else if (digit == '7') {
            result = new char[4];
            result[0] = 'p';
            result[1] = 'q';
            result[2] = 'r';
            result[3] = 's';
        } else if (digit == '8') {
            result = new char[3];
            result[0] = 't';
            result[1] = 'u';
            result[2] = 'v';
        } else {
            result = new char[4];
            result[0] = 'w';
            result[1] = 'x';
            result[2] = 'y';
            result[3] = 'z';
        }
        return result;
    }

    private void combo_back_tracking(String digits, int begin, List<String> result, StringBuilder temp) {
        if (begin == digits.length()) {
            result.add(temp.toString());
            return;
        }
        char []choose_list = digit_to_letter(digits.charAt(begin));
        for (char c : choose_list) {
            temp.append(c);
            combo_back_tracking(digits, begin+1, result, temp);
            temp.delete(temp.length()-1, temp.length());
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) {
            return new ArrayList();
        }
        List<String> result = new ArrayList();
        combo_back_tracking(digits, 0, result, new StringBuilder());
        return result;
    }
}