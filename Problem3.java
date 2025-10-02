// Time Complexity : O(M * L + N * L) where M is the number of words in dictionary, N is number of words in sentence and L is the average word length
// Space Complexity : O(M * L + N * L) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use Trie to insert each word given in dictionary
//Split the sentence and for each word iterate over it to get the char 
// We find a replacement string if isEnd is true and that char is present in TrieNode
//If the char is not present in Trienode we keep the word as it is.

class Solution {
    TrieNode root;

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            if(cur.isEnd) break;
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for (String word : dictionary) {
            insert(word);
        }
        StringBuilder res = new StringBuilder();
        String[] strArr = sentence.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            //get the each string
            if(i > 0) res.append(" ");
            String str = strArr[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode cur = root;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (cur.children[ch - 'a'] == null || cur.isEnd)
                    break;
                replacement.append(ch);
                cur = cur.children[ch - 'a'];
            }
            if (cur.isEnd) {
                res.append(replacement);
            } else {
                res.append(str);
            }

        }

        return res.toString();

    }
}
