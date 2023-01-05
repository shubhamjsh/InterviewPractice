package org.example.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieImplementation {
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private  final TrieNode root;
    public TrieImplementation() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    public boolean startsWith(String pattern) {
        TrieNode current = root;
        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null)
                return false;
            current = node;
        }
        return true;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    public boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()) {
            if(!current.endOfWord)
                return false;
            current.endOfWord = false;
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null)
            return false;

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if(shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

    //Leetcode 211
//    public boolean searchWithDot(String word) {
//        TrieNode current = root;
//        for(int i = 0; i < word.length(); i++) {
//            char ch = word.charAt(i);
//            if(ch == '.')
//                continue;
//            TrieNode node = current.children.get(ch);
//            if(node == null) {
//                return false;
//            }
//            current = node;
//        }
//        return current.endOfWord;
//    }

    public static void main(String[] args) {
        TrieImplementation obj = new TrieImplementation();
        String[] arr = {"new", "newly", "newl"};
//        for(int i=0; i< arr.length; i++) {
//            obj.insert(arr[i]);
//            obj.search(arr[i]);
//        }

        obj.insert(arr[0]);
//        obj.insert(arr[1]);
        obj.delete("new");
    }
}
