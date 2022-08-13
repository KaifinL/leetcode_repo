class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Boolean> mapping = new HashMap();
        List<String> result = new ArrayList();
        for (int i = 0; i + 9 < s.length(); i++) {
            String curr = s.substring(i, i+10);
            if (mapping.get(curr) == null) {
                mapping.put(curr, false);
            } else if (mapping.get(curr) == false) {
                result.add(curr);
                mapping.put(curr, true);
            } 
        }
        return result;
    }
}