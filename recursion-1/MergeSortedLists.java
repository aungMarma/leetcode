class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        helper(dummy, l1, l2);
        return dummy.next;
    }

    public void helper(ListNode head, ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                helper(head.next, l1.next, l2);
            } else {
                head.next = l2;
                helper(head.next, l1, l2.next);
            }

        } else if (l1 != null) {
            head.next = l1;
            helper(head.next, l1.next, l2);
        } else if (l2 != null) {
            head.next = l2;
            helper(head.next, l1, l2.next);
        }

    }
}