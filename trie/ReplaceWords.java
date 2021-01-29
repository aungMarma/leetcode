import java.util.*;

// this is my solution
class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }

        String[] result = sentence.split("\\s");
        String ans = "";
        for (int i = 0; i < result.length; ++i) {
            String newStr = trie.searchPrefix(result[i]);
            if (newStr != null) {
                if (i == result.length - 1) {
                    ans += newStr;
                } else {
                    ans += newStr + " ";
                }
            } else {
                if (i == result.length - 1) {
                    ans += result[i];
                } else {
                    ans += result[i] + " ";
                }
            }
        }
        return ans;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.value = word;
        node.isEnd = true;
    }

    public String searchPrefix(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return null;
            }
            if (node.isEnd) {
                return node.value;
            }
        }

        // word is smaller than all prefix in trie
        if (node != null) {
            return node.value;
        }
        return null;
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
    String value;
}