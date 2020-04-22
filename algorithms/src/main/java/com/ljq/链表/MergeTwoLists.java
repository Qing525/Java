package com.ljq.链表;

/**
 * @author : lijq
 * @date : 2019/12/26 23:14
 */
public class MergeTwoLists {
    public SingleListNode mergeTwoLists(SingleListNode l1, SingleListNode l2) {
        SingleListNode newList = new SingleListNode(0);
        SingleListNode lastNode = newList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;

        }
        lastNode.next = l1 != null ? l1 : l2;
        return newList;

    }
}
