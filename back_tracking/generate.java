class Solution {

    public void addNums(List<List<Integer>> result, List<Integer> prev, int curr, int numRows) {
        if (curr > numRows) {
            return;
        }
        List<Integer> temp = new ArrayList();
        temp.add(1);
        for (int i = 0; i+1<prev.size(); i++) {
            temp.add(prev.get(i)+prev.get(i+1));
        }
        temp.add(1);
        result.add(temp);
        addNums(result, temp, curr+1, numRows);
    }

    public List<List<Integer>> generate(int numRows) {
        List<Integer> first = new ArrayList();
        first.add(1);
        List<List<Integer>> result = new ArrayList();
        result.add(first);
        addNums(result, first, 2, numRows);
        return result;
    }
}