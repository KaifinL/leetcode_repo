class Solution {
	public static int addPow(int []arr) {
		int increased = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] + increased < arr[i-1]) {
				increased += (arr[i-1]-(arr[i]+increased));
				arr[i] = arr[i-1];
			} else {
				arr[i] = Math.min(9, arr[i]+increased);
			}
		}
		return increased;
	}

	public static void main(String[] argv) {
		System.out.println(addPow(new int[] {3,4, 1, 6, 2}));
	}
}