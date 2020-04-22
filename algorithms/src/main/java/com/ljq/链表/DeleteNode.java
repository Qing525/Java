package com.ljq.链表;

/**
 * @author : lijq
 * @date : 2019/12/26 22:53
 * leetcode 237
 */
public class DeleteNode {
    /**
     * 删除链表中的节点
     *
     * @param node
     */
    public static void deleteNode(SingleListNode node) {

        //将待删除节点的下一个节点的值赋给待删除节点
        node.val = node.next.val;
        //将待删除节点的引用指向 下下个节点
        node.next = node.next.next;

    }
}
