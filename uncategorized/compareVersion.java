class Solution {
    public int compareVersion(String version1, String version2) {
        String []first = version1.split("\\.");
        String []second = version2.split("\\.");
        int i;
        for (i = 0; i < Math.min(first.length, second.length); i++) {
            int curr1 = Integer.parseInt(first[i]);
            int curr2 = Integer.parseInt(second[i]);
            if (curr1 < curr2) {
                return -1;
            } else if (curr1 > curr2) {
                return 1;
            }
        }
        if (i == first.length) {
            for (; i < second.length; i++) {
                int curr = Integer.parseInt(second[i]);
                if (curr != 0) {
                    return -1;
                } 
            }
        } else {
            for (; i < first.length; i++) {
                int curr = Integer.parseInt(first[i]);
                if (curr != 0) {
                    return 1;
                } 
            }
        }
        return 0;
    }
}