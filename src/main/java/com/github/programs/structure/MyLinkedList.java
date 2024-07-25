package com.github.programs.structure;

public class MyLinkedList {
    ListNode head;
    int size;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        // 处理异常逻辑
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head;
        for (int i = 0; i <= index ; i ++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 处理异常逻辑
        if (index > size) {
            return ;
        }

        // 如果index == negative number, 在头部插入即可
        index = Math.max(index, 0);

        // 扩大链表的大小, 即刻生效
        ++ size;

        // 新增一个辅助指针
        ListNode pre = head;
        for (int i = 0; i < index ; i ++) {
            pre = pre.next;
        }
        ListNode toAddNode = new ListNode(val);
        toAddNode.next = pre.next;
        pre.next = toAddNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return ;
        }
        --size;
        // 新增一个辅助指针
        ListNode pre = head;
        for (int i = 0; i < index ; i ++) {
            pre = pre.next;
        }
        pre.next =  pre.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2); // 链表变为 1->2->3
        System.out.println(myLinkedList.get(1)); // 返回 2
        myLinkedList.deleteAtIndex(1); // 现在，链表变为 1->3
        System.out.println(myLinkedList.get(1)); // 返回 3
    }
}

