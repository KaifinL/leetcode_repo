class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        int []nd = new int[length+1];
        nd[length] = 1;
        nd[length-1] = Integer.parseInt(s.substring(length-1))==0 ? 0:1;
        for (int i = length-2; i>= 0; i--) {
            int notZero = Integer.parseInt(s.substring(i, i+1))==0 ? 0:1;
            int nextValid = Integer.parseInt(s.substring(i, i+2));
            if (nextValid>=10 && nextValid <= 26) {
                nextValid = 1;
            } else {
                nextValid = 0;
            }
            nd[i] = notZero*nd[i+1] + nextValid*nd[i+2];
        }
        return nd[0];
    }
}