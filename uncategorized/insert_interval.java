class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();
        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else {
                break;
            }
        }
        if (i == intervals.length) {
            result.add(newInterval);
        } else {
            int first = Math.min(intervals[i][0], newInterval[0]);
            for (;i < intervals.length; i++) {
                if (intervals[i][0] > newInterval[1]) {
                    break;
                }
            }
            // check boundary
            if (i==0) {
                result.add(newInterval);
            } else {
                int second = Math.max(intervals[i-1][1], newInterval[1]);
                result.add(new int[]{first, second});
            }
            for (; i < intervals.length; i++) {
                result.add(intervals[i]);
            }
        }
        

        int [][]final_result = new int[result.size()][2];
        for (i = 0; i < result.size(); i++) {
            final_result[i] = result.get(i);
        }
        return final_result;
    }
}