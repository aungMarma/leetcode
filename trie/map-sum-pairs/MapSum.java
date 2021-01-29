import java.util.Map;
import java.util.HashMap;

// this is my solution
class MapSum {
    private class TrieNode {
        int value;
        boolean isEnd;
        HashMap<Character, TrieNode> paths = new HashMap<>();
    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); ++i) {
            char ch = key.charAt(i);
            if (!node.paths.containsKey(ch)) {
                node.paths.put(ch, new TrieNode());
            }
            node = node.paths.get(ch);
        }
        node.value = val;
        node.isEnd = true;
    }

    public int sum(String prefix) {
        TrieNode node = findPrefix(prefix);
        if (node == null) {
            return 0;
        }
        return sumPairs(node);
    }

    public int sumPairs(TrieNode node) {
        int total = 0;
        if (node.isEnd) {
            total += node.value;
        }
        for (Map.Entry<Character, TrieNode> entry : node.paths.entrySet()) {
            total += sumPairs(entry.getValue());
        }
        return total;
    }

    public TrieNode findPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (!node.paths.containsKey(ch)) {
                return null;
            }
            node = node.paths.get(ch);
        }
        return node;
    }
}