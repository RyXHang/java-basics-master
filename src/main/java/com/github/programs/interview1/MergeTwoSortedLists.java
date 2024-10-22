package com.github.programs.interview1;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 临时头结点
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 处理剩余的节点
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next; // 返回合并后的链表头结点
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getNext() {
            return this.next;
        }

        public int getVal() {
            return this.val;
        }
    }

}
