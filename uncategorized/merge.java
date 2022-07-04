class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int []a, int[]b)->(a[0]-b[0]));
        List<int []> result = new ArrayList();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int []curr = intervals[i];
            int []last = result.get(result.size()-1);
            if (curr[0] == last[0]) {
                result.remove(result.size()-1);
                result.add((curr[1]>last[1] ? curr:last));
            } else {
                if (curr[0] <= last[1]) {
                    result.remove(result.size()-1);
                    int new_interval = new int[2];
                    new_interval[0] = last[0];
                    new_interval[1] = Math.max(curr[1], last[1]);
                    result.add(new_interval);
                } else {
                    result.add(curr);
                }
            }
        }
        int [][]final_result = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            final_result[i] = result.get(i);
        }
        return final_result;
    }
}