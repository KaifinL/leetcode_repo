class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int)((long)find_maximum_integral(h, horizontalCuts) * find_maximum_integral(w, verticalCuts)%1000000007);
    }

    private int find_maximum_integral(int total, int []arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = Math.max(result, (arr[i]-arr[i-1]));
        }
        result = Math.max(result, total-arr[arr.length-1]);
        return result;
    }
}