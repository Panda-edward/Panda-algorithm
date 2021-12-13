package com.panda.algorithm.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Edward
 * @Date: 2020/7/22 上午12:21
 * <p>
 * 单向链表节点实现
 */
public class ListNode {

    public int val;

    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode init(int... nums) {
        //先init一个空节点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        head = head.next;
        return head;
    }

    @Override
    public String toString(){
//        StringBuilder builder = new StringBuilder();
//        ListNode p = this;
//        while (p != null) {
//            builder.append(p.val).append(",");
//            p = p.next;
//        }
//        return "{"+builder.substring(0,builder.length()-1)+"}";

        List<Integer> list = new ArrayList<>();
        ListNode p = this;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        return list.toString();
    }
}
