package com.ljq.链表;

import java.util.Stack;

/**
 * @author : lijq
 * @date : 2020/1/21 14:03
 * <p>
 * 反转链表
 * <p>
 * 思路： 1.每个节点的指针域 指向下一个节点 ---变成- --->  指向前一个节点
 * 2.利用栈先进后出的特性
 */
public class ReverseNode {

    public static SingleListNode reverseNode(SingleListNode head) {

        if (head == null || head.getNext() == null) {
            return head;
        }
        SingleListNode preNode = null;
        SingleListNode curNode = head;
        SingleListNode nextNode = null;

//        while (curNode != null) {
//            nextNode = curNode.getNext();
//            curNode.setNext(preNode);
//            preNode = curNode;
//            curNode = nextNode;
//        }
        while (curNode != null) {
            nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }


    public static SingleListNode reverseStackNode(SingleListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<SingleListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (!stack.empty()) {
            head = stack.pop();
        }
        while (!stack.empty()) {
            SingleListNode curNode = stack.pop();
            curNode.getNext().setNext(curNode);
            curNode.setNext(null);
        }


        return head;
    }

    public static void main(String[] args) {
        SingleListNode node1 = new SingleListNode(1);
        SingleListNode node2 = new SingleListNode(2);
        SingleListNode node3 = new SingleListNode(3);
        SingleListNode node4 = new SingleListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);
        SingleListNode.show(node1);
        System.out.println("=================================");
//        SingleListNode node = reverseStackNode(node1);
//        SingleListNode.show(node);
        SingleListNode node = reverseNode(node1);
        SingleListNode.show(node);
    }
}
