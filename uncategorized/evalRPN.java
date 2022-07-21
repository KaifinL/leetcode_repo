/*
passed the tests. this is a problem related to data structure. 
Since the problem already suggests "reverse", a stack should be used here.
*/



class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                int first = values.pop();
                int second = values.pop();
                if (token.equals("+")) {
                    values.push(first+second);
                } else if (token.equals("-")) {
                    values.push(second-first);
                } else if (token.equals("*")) {
                    values.push(first*second);
                } else {
                    values.push(second/first);
                }
            } else {
                values.push(Integer.parseInt(token));
            }
        }
        return values.peek();
    }
}