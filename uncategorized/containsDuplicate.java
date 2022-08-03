class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> appeared = new HashSet();
        for (int curr:nums) {
            if (appeared.contains(curr)) {
                return true;
            } else {
                appeared.add(curr);
            }
        }
        return false;
    }
}