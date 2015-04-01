public class HouseRobber {
	public int rob(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}

		int[] rob = new int[num.length + 1];
		rob[0] = 0;
		rob[1] = num[0];

		for (int i = 2; i < rob.length; i++) {
			rob[i] = Math.max(rob[i - 1], rob[i - 2] + num[i - 1]);
		}

		return rob[num.length];
	}
}
