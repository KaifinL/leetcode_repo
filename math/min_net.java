class Solution {
	public static int min_net(int []stock) {
		int sum = 0;
		for (int i = 0; i < stock.length; i++) {
			sum += stock[i];
		}
		int temp_sum = 0;
		int result = 0;
		int minimum = sum / stock.length;
		for (int i = 1; i < stock.length; i++) {
			temp_sum += stock[i];
			int first_average = temp_sum/i;
			int second_average = (sum-temp_sum) / (stock.length-i);
			if (Math.abs(first_average-second_average) < minimum) {
				result = i;
				minimum = Math.abs(first_average-second_average);
			}
		}
		return result;
	}

	public static void main(String[] argv) {
		System.out.println(min_net(new int[]{1, 3, 2, 4}));
	}
}