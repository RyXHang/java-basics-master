package com.github.programs.interview;

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 != null) p1 = p1.next;
            else {
                p1 = headB;
            }

            if (p2 != null) p2 = p2.next;
            else {
                p2 = headA;
            }
        }
        return p1;
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

    public static void main(String[] args) {
        IntersectionNode intersectionNode = new IntersectionNode();

        // 创建链表有交点的情况
        ListNode common = intersectionNode.new ListNode(8);
        common.setNext(intersectionNode.new ListNode(10));

        ListNode headA = intersectionNode.new ListNode(4);
        headA.setNext(intersectionNode.new ListNode(1));
        headA.getNext().setNext(common); // 链表A: 4 -> 1 -> 8 -> 10

        ListNode headB = intersectionNode.new ListNode(5);
        headB.setNext(intersectionNode.new ListNode(6));
        headB.getNext().setNext(intersectionNode.new ListNode(1));
        headB.getNext().getNext().setNext(common); // 链表B: 5 -> 6 -> 1 -> 8 -> 10

        // 测试带交点的情况
        ListNode result = intersectionNode.getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.getVal()); // 应输出 8
        } else {
            System.out.println("No intersection.");
        }

        // 创建链表没有交点的情况
        ListNode headC = intersectionNode.new ListNode(2);
        headC.setNext(intersectionNode.new ListNode(3)); // 链表C: 2 -> 3

        result = intersectionNode.getIntersectionNode(headA, headC);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.getVal());
        } else {
            System.out.println("No intersection."); // 应输出 No intersection.
        }
    }

}
