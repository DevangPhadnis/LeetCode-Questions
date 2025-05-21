public class TrieNode {
    TrieNode child[] = new TrieNode[26];
    boolean isEnd;
    public TrieNode() {
        isEnd = false;
        for(int i=0;i<26;i++) {
            child[i] = null;
        }
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i < word.length();i++) {
            int idx = word.charAt(i) - 'a';
            if(node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }
            node = node.child[idx];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';
            if(node.child[idx] == null) {
                return false;
            }
            node = node.child[idx];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++) {
            int idx = prefix.charAt(i) - 'a';
            if(node.child[idx] == null) {
                return false;
            }
            node = node.child[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */