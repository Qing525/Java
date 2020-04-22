package com.ljq.链表;

/**
 * @author : lijq
 * @date : 2019/12/26 22:26
 */
public class SingleListNode {
    SingleListNode next;
    int val;

    public SingleListNode(int val) {
        this.val = val;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }

    public static void show(SingleListNode head) {
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }

    @Override
    public String toString() {
        return "SingleListNode{" +
                "val=" + val +
                '}';
    }
}
