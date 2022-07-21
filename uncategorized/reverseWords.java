class Solution {
    public String reverseWords(String s) {
        List<String> original = new ArrayList();
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (curr.length() != 0) {
                    original.add(curr.toString());
                    curr.delete(0, curr.length());
                }
            } else {
                curr.append(s.substring(i, i+1));
            }
        }
        if (curr.length() != 0) {
            original.add(curr.toString());
        }

        curr = new StringBuilder(original.get(original.size()-1));
        for (int i = original.size()-2; i>=0; i--) {
            curr.append(" ");
            curr.append(original.get(i));
        }
        return curr.toString();
    }
}