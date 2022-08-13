class Solution {

    private void addNums(List<List<Integer>> result, List<Integer> temp, int k, int remain, int begin) {
        if (temp.size() == k) {
            if (remain == 0) {
                result.add(new ArrayList(temp));
            }
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = begin; i < 10; i++) {
            temp.add(i);
            addNums(result, temp, k, remain-i, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        addNums(result, new ArrayList(), k, n, 1);
        return result;
    }
}