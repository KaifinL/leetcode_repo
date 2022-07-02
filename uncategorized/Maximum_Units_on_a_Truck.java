class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (int []a, int[]b)->b[1]-a[1]);
        int result = 0;
        int index =0;
        while (truckSize > 0 && index < boxTypes.length) {
            int curr = Math.min(truckSize, boxTypes[index][0]);
            result += curr*boxTypes[index][1];
            truckSize-= curr;
            index++;
        }
        return result;
    }
}