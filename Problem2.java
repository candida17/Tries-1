// Time Complexity : O(N * L) — N is number of words, L is average word length (for insertions and BFS traversal).
// Space Complexity : O(N * L) — for storing the Trie and the BFS queues.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We insert a TrieNode for each word given in words array
// We perform a BFS traversal by mainataining a queue for TrieNode and queue for longest string
// we do a lexicographic check by iterating backwards and return the longest word

class Solution {
    TrieNode root;

    class TrieNode {
        boolean isEnd;
        TrieNode [] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    
    private void insert(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    public String longestWord(String[] words) {
        this.root = new TrieNode();
        String res = "";
        //create a TrieNode for each word in words []
        for(String word: words) {
            insert(word);
        }

        res = bfs(this.root);
        return res;
        
    }

    private String bfs(TrieNode curr) {
        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> strQ = new LinkedList<>();
        String curStr =  "";
        q.add(curr);
        strQ.add(curStr);

        while(!q.isEmpty()) {
            curr = q.poll();
            curStr = strQ.poll();
            for(int i = 25; i >= 0; i--) {
                if(curr.children[i] != null && curr.children[i].isEnd) {
                    q.add(curr.children[i]);
                    strQ.add(curStr + (char)(i + 'a'));
                }
            }
            
        }
        return curStr;

    }
}
