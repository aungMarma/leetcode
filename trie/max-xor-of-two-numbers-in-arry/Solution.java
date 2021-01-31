import java.util.*;
class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode() {
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for (int num : nums)
            maxNum = Math.max(maxNum, num);
        int L = Integer.toBinaryString(maxNum).length();

        int bitMask = 1 << L, n = nums.length;
        String[] strNums = new String[n];
        for (int i = 0; i < n; i++)
            strNums[i] = Integer.toBinaryString(bitMask | nums[i]).substring(1);

        TrieNode trie = new TrieNode();
        int maxXOR = 0;
        for (String num : strNums) {
            int currentXOR = 0;
            TrieNode node = trie, xorNode = trie;

            for (char bit : num.toCharArray()) {
                // insert to trie and move along the trie
                node.children.putIfAbsent(bit, new TrieNode());
                node = node.children.get(bit);

                char oppositeBit = bit == '1' ? '0' : '1';
                if (xorNode.children.containsKey(oppositeBit)) {
                    currentXOR = (currentXOR << 1) | 1;
                    xorNode = xorNode.children.get(oppositeBit);
                } else {
                    currentXOR = currentXOR << 1;
                    xorNode = xorNode.children.get(bit);
                }
            }

            maxXOR = Math.max(maxXOR, currentXOR);
        }
        return maxXOR;
    }
}