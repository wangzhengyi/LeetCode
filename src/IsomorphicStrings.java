import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Integer> mapS = new HashMap<>();
		HashMap<Character, Integer> mapT = new HashMap<>();

		for (int i = 0, len = s.length(); i < len; i ++) {
			if (!mapS.containsKey(s.charAt(i)) && !mapT.containsKey(t.charAt(i))) {
				mapS.put(s.charAt(i), i);
				mapT.put(t.charAt(i), i);
				continue;
			}
			
			if (!mapS.containsKey(s.charAt(i)) || !mapT.containsKey(t.charAt(i))) {
				return false;
			}
			
			if (mapS.get(s.charAt(i)) != mapT.get(t.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			String s = cin.nextLine();
			String t = cin.nextLine();

			boolean res = isIsomorphic(s, t);

			System.out.println(res);
		}

		cin.close();
	}
}
