package com.ljq.链表;

/**
 * @author : lijq
 * @date : 2020/4/6 16:17
 */
public class Test {
    public static void main(String[] args) {
        SingleListNode node1 = new SingleListNode(1);
        SingleListNode node2 = new SingleListNode(2);
        SingleListNode node3 = new SingleListNode(3);
        SingleListNode node4 = new SingleListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);
//        SingleListNode.show(node1);
//        DeleteNode.deleteNode(node3);
//        SingleListNode.show(node1);
//        SingleListNode node = RemoveNthFromEnd.removeNthFromEnd(node1, 2);
//        System.out.println(node);
DeleteNode.deleteNode(node4);
        SingleListNode.show(node1);
    }
}
