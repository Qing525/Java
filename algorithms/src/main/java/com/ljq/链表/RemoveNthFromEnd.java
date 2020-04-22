package com.ljq.链表;

/**
 * @author : lijq
 * @date : 2020/4/6 17:05
 */
public class RemoveNthFromEnd {
    public static SingleListNode removeNthFromEnd(SingleListNode head, int n) {
        int i = 0;
        SingleListNode temp = head;
        SingleListNode first =new SingleListNode(0);
        first.next=head;
        SingleListNode temp1=first;
        while (head != null) {
            i++;
            head = head.next;
        }
        if (i == 1) {
            return null;
        }
        int del = i - n - 1;
        while (del > 0) {
            temp = temp.next;
            del--;
        }
        temp.next = temp.next.next;

        return temp1.next;
    }


}
