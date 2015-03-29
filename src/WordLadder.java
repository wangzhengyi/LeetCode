import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordLadder {
	public static int ladderLength(String start, String end, Set<String> dict) {
		int dist = calDistance(start, end);
		if (dist == 1) {
			return 2;
		}

		return bfsDict(dict, start, end);
	}

	private static int calDistance(String word1, String word2) {
		int dist = 0;

		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				dist += 1;
			}
		}

		return dist;
	}

	private static void enQueue(Set<String> dict, LinkedList<String> queue, String target, Map<String, Integer> map,
			int step) {
		if (dict == null || dict.isEmpty()) {
			return;
		}

		for (int i = 0; i < target.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				StringBuilder sBuilder = new StringBuilder(target);
				if (sBuilder.charAt(i) == c) {
					continue;
				}
				sBuilder.setCharAt(i, c);
				if (dict.contains(sBuilder.toString())) {
					queue.addLast(sBuilder.toString());
					dict.remove(sBuilder.toString());
					map.put(sBuilder.toString(), step + 1);
				}
			}
		}
	}

	private static int bfsDict(Set<String> dict, String start, String end) {
		LinkedList<String> queue = new LinkedList<String>();
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		enQueue(dict, queue, start, hashMap, 1);

		while (!queue.isEmpty()) {
			String word = queue.poll();
			int step = hashMap.get(word);
			if (calDistance(word, end) == 1) {
				return step + 1;
			}

			enQueue(dict, queue, word, hashMap, step);
		}

		return 0;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			String start = cin.next();
			String end = cin.next();

			int n = cin.nextInt();
			Set<String> dict = new HashSet<String>();
			for (int i = 0; i < n; i++) {
				dict.add(cin.next());
			}

			int len = ladderLength(start, end, dict);

			System.out.print(len);
		}

		cin.close();
	}

}
