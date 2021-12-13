package com.panda.algorithm.list;

import com.panda.algorithm.common.ListNode;

/**
 * @author : Edward
 * @date : 2020/10/20 下午4:01
 */
public class ReverseLinkedList {

    /**
     * 反转链表
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * K个一组反转链表
     */
    public static ListNode reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        int i = 1;
        while (cur != null && i < k) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }
        //
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.init(1, 2, 3, 4, 5);
        System.out.println(head.toString());
        ListNode reverse = reverse(head);
        System.out.println(reverse.toString());
    }
}
