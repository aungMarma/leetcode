class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}

// these are my solutions
class SwapNodes {
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        head.next = swapPairsRecursive(head.next);
        return next;
    }

    public ListNode swapPairs(ListNode curr) {
        if (curr == null || curr.next == null)
            return curr;

        ListNode newHead = null, prev = null;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            if (newHead == null) {
                newHead = temp;
            }

            if (prev != null) {
                prev.next = temp;
            }
            prev = curr;
            curr = curr.next;
        }
        return newHead;
    }
}

// leetcode officia solutions
class leetcode {
    public ListNode swapPairsRecursive(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next = swapPairsRecursive(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }

    public ListNode swapPairs(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}