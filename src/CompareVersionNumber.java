import java.util.ArrayList;
import java.util.Scanner;

public class CompareVersionNumber {
	public static int compareVersion(String version1, String version2) {
		if (version1.equals(version2)) {
			return 0;
		}
		
		ArrayList<Integer> list1 = splitStr(version1);
		ArrayList<Integer> list2 = splitStr(version2);
		
		int len = list1.size() < list2.size() ? list1.size() : list2.size();
		
		int i;
		for (i = 0; i < len; i ++) {
			if (list1.get(i) > list2.get(i)) {
				return 1;
			}
			
			if (list1.get(i) < list2.get(i)) {
				return -1;
			}
		}
		
		int j;
		
		for (j = i; j < list1.size(); j ++) {
			if (list1.get(j) > 0) {
				return 1;
			}
		}
		
		for (j = i; j < list2.size(); j ++) {
			if (list2.get(j) > 0) {
				return -1;
			}
		}
		
		return 0;
	}

	
	private static ArrayList<Integer> splitStr(String str) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (String s : str.split("\\.")) {
			list.add(Integer.parseInt(s));
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			String version1 = cin.next();
			String version2 = cin.next();

			System.out.println(compareVersion(version1, version2));
		}

		cin.close();
	}
}
