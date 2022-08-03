class Solution {
    public String countAndSay(int n) {
        if (n==1) {
            return "1";
        }
        String previous = countAndSay(n-1);
        char curr=previous.charAt(0);
        int counter = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < previous.length(); i++) {
            if (previous.charAt(i)==curr) {
                counter++;
            } else if (counter != 0) {
                result.append(Integer.toString(counter));
                result.append(curr);
                curr = previous.charAt(i);
                counter = 1;
            }
        }
        result.append(Integer.toString(counter));
        result.append(curr);
        return result.toString();
    }
}