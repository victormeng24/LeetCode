package ImplementTrie;

import util.TreeNode;

public class Trie {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
    }
    class TrieNode {
        TrieNode[] child;
        boolean isWord;
        char content;
        TrieNode() {
            this.child = new TrieNode[26];
        }
        TrieNode(char c) {
            this.content = c;
            this.child = new TrieNode[26];
        }
    }
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode temp = root;
        if (word.length() < 1) return;
        for (int i = 0; i < word.length(); i++) {
            if (temp.child[word.charAt(i) - 'a'] == null) {
                temp.child[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            }
            temp = temp.child[word.charAt(i) - 'a'];
        }
        temp.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word.length() < 1) return true;
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (temp.child[word.charAt(i) - 'a'] == null) return false;
            temp = temp.child[word.charAt(i) - 'a'];
        }
        return temp.isWord == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.child[prefix.charAt(i) - 'a'] == null) return false;
            temp = temp.child[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
