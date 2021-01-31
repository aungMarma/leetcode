class ListNode {
    int val;
    ListNode next;
}
class SwapNodes {
    public ListNode swapPairsRecursive(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        head.next = swapPairsRecursive(head.next);
        return next;
    }
    public ListNode swapPairs(ListNode curr) {
        if(curr == null || curr.next == null) return curr;
        
        ListNode newHead = null, prev = null;
        while(curr != null && curr.next != null){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            if(newHead == null){
                newHead = temp;
            }
            
            if(prev != null){
                prev.next = temp;
            }
            prev = curr;
            curr = curr.next;
        }
        return newHead;
    }
}