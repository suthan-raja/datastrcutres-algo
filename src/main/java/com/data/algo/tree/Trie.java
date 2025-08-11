package com.data.algo.tree;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
    }
}
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
        }

        return ( current != null && current.isEndOfWord);
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }

        return true;
    }

    public void printAllWords() {
        printAllWordsHelper(root, "");
    }

    private void printAllWordsHelper(TrieNode node, String word) { //
        if (node.isEndOfWord) {
            System.out.println(word);
        }

        for (int i = 0; i < 26; i++) { //
            if (node.children[i] != null) { // a p
                char ch = (char) ('a' + i); // a p
                printAllWordsHelper(node.children[i], word + ch); // a, a - p ,ap - l -apl, e-aple
            }
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("aple");
        trie.printAllWords();
    }

}
