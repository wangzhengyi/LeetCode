public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		if (n <= 0) {
			return "";
		}

		StringBuilder res = new StringBuilder();
		String alphabets[] = { "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
				"Q", "R", "S", "T", "U", "V", "W", "X", "Y" };

		while (n > 0) {
			int num = n % 26;
			res.append(alphabets[num]);
			n = num == 0 ? n / 26 - 1 : n / 26;
		}

		return res.reverse().toString();
	}
}
