package org.jf.util;

import java.util.LinkedList;
import java.util.List;

public class TrieTree {

    //The root node of TrieTree
    private final TrieNode root = new TrieNode();

    //The node type of TrieTree
    private static class TrieNode {
        char content;
        String word;
        boolean isEnd = false; // This node is whether the end of a word
        LinkedList<TrieNode> children = new LinkedList<>();

        public TrieNode() {}

        public TrieNode(char content, String word) {
            this.content = content;
            this.word    = word;
        }


        @Override
        public boolean equals(Object object) {
            if (object instanceof TrieNode) {
                return ((TrieNode) object).content == content;
            }
            return false;
        }

        public TrieNode nextNode(char content) {
            for (TrieNode childNode : children) {
                if (childNode.content == content)
                    return childNode;
            }
            return null;
        }
    }

    public void add(String word) {
        if (word == null)
            return;

        TrieNode current = root;
        StringBuilder wordBuilder = new StringBuilder();

        char content;
        TrieNode node;
        for (int index = 0; index < word.length(); ++index) {
            content = word.charAt(index);
            wordBuilder.append(content);
            node = new TrieNode(content, wordBuilder.toString());
            if (current.children.contains(node)) {
                current = current.nextNode(content);
            } else {
                if (index == word.length() - 1)
                    node.isEnd = true;
                current.children.add(node);
                current = node;
            }

            if (index == (word.length() - 1))
                current.isEnd = true;
        }
    }

    public void addAll(List<String> words) {
        for (String word : words) {
            add(word);
        }
    }

    public boolean search(String word) {
        if (word == null)
            return false;

        TrieNode current = root;

        char content;
        for (int index = 0; index < word.length(); ++index) {
            content = word.charAt(index);

            if (current.isEnd)
                break;

            TrieNode node = new TrieNode(content, null);
            if (current.children.contains(node))
                current = current.nextNode(content);
            else
                return false;
        }
        return current.isEnd;
    }
}
