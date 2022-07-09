class Solution {
    class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        combo(result, new ArrayList(), 1, k, n);
        return result;
    }

    private void combo(List<List<Integer>> result, List<Integer> temp,
            int start, int k, int n) {
        if (temp.size() == k) {
            result.add(new ArrayList(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            combo(result, temp, i+1, k, n);
            temp.remove(temp.size()-1);
        }
    }
}
}