import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RepeatedDNASequences {
	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> resList = new ArrayList<String>();
		if (s == null || s.length() <= 10) {
			return resList;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i <= s.length() - 10; i ++) {
			String substr = s.substring(i, i + 10);
			int key = hashCode(substr);
			
			if (set.contains(key) && !resList.contains(substr)) {
				resList.add(substr);
			} else {
				set.add(key);
			}
		}
		
		return resList;
	}

	
	private static int hashCode(String str) {
		int hash = 0;
		
		for (int i = 0; i < str.length(); i ++) {
			hash = hash << 2 | mapInteger(str.charAt(i));
		}
		
		return hash;
	}
	
	private static int mapInteger(char ch) {
		switch (ch) {
		case 'A':
			// 00
			return 0;
		case 'C':
			// 01
			return 1;
		case 'G':
			// 10
			return 2;
		case 'T':
			// 11
			return 3;
		default :
			return 0;
		}
	}
	
	
	public static List<String> findRepeatedDnaSequencesNative(String s) {
		List<String> resList = new ArrayList<String>();
		if (s == null || s.length() <= 10) {
			return resList;
		}

		Set<String> sets = new HashSet<String>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String key = s.substring(i, i + 10);
			if (sets.contains(key) && ! resList.contains(key)) {
				resList.add(key);
			} else {
				sets.add(key);
			}
		}

		return resList;
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			String s = cin.next();
			List<String> res = findRepeatedDnaSequences(s);

			for (String str : res) {
				System.out.println(str);
			}
		}

		cin.close();
	}
}
