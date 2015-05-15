import java.util.HashMap;

class TrieNode {
	boolean isWord;
	HashMap<Character, TrieNode> nexts;
	
	public TrieNode() {
		nexts = new HashMap<Character, TrieNode>();
	}
}


public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] s = word.toCharArray();
        
        TrieNode p = root;
        int i = 0, n = s.length;
        
        // traverse existing
        while (i < n) {
        	TrieNode next = p.nexts.get(s[i]);
        	if (next != null) {
        		p = next;
        		i ++;
        	} else {
        		break;
        	}
        }
        
        // append new nodes
        while (i < n) {
        	TrieNode newTrie = new TrieNode();
        	p.nexts.put(s[i], newTrie);
        	p = newTrie;
        	i ++;
        }
        
        // set word end
        p.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode p = root;
    	
        for (int i = 0; i < word.length(); i ++) {
        	TrieNode child = p.nexts.get(word.charAt(i));
        	if (child == null) {
        		return false;
        	}
        	p = child;
        }
        
        return p.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        
        for (int i = 0; i < prefix.length(); i ++) {
        	TrieNode child = p.nexts.get(prefix.charAt(i));
        	if (child == null) {
        		return false;
        	}
        	p = child;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	trie.insert("keydsdsds");
    	System.out.println(trie.startsWith("key"));
    }
}
