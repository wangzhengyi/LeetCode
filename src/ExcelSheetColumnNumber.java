public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - 'A' + 1;
			sum = sum * 26 + num;
		}

		return sum;
	}
}
