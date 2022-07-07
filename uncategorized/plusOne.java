class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1;
        while (index >= 0 && digits[index] == 9) {
            digits[index] = 0;
            index--;
        }
        if (index == -1) {
            int []result = new int[digits.length+1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        } else {
            digits[index] += 1; 
        }
        return digits;
    }
}