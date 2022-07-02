class Solution {
    public List<String> restoreIpAddresses(String s) {
        List <String> result = new ArrayList();
        add_helper(result, s, 3);
    }

    private void add_helper(List<String> result, String s, int remain) {
        if (result.length() > (remain+1)*3 || remain < 0) {
            return;
        }
        if (result.startWith("0")) {
            add_helper(result, s.substring(1), remain-1);
            if (result != null) {
                int size = result.size();
                while (size > 0) {
                    StringBuilder curr = StringBuilder(result.remove(0));
                    curr = "0." + curr; 
                    result.add(curr.toString());
                }
            }
        } else {
            // now either to make the current 
        }
    }
}