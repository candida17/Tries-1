// Time Complexity : O(L) - L is the length of the word
// Space Complexity : O(N * L) where N is number of words and L is average word length 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We create a TrieNode of 26 letters to store each characters of given word
//for insert, search or prefix method we locate the character TrieNode using ch - 'a'
//we use isEnd flag to determine the end of word in the TrieNode array
class Trie {
    class TrieNode {
        boolean isEnd;
        TrieNode [] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i< word.length(); i++) {
            char ch = word.charAt(i);
            if(cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isEnd = true;    
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(cur.children[ch - 'a'] == null) return false;
            cur = cur.children[ch - 'a'];
        }
        return cur.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i< prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(cur.children[ch - 'a'] == null) return false;
            cur = cur.children[ch - 'a'];
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
