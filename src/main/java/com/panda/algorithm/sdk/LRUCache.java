package com.panda.algorithm.sdk;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Edward
 * @Date: 2020/8/7 下午8:11
 */
public class LRUCache {

    /**
     * 缓存队列头、尾虚节点
     */
    private Node head, tail;

    /**
     * map映射
     */
    private Map<String, Node> map;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 当前元素数量
     */
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        //init 双向链表
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void put(String key, Object value) {
        /*
         * 查询元素
         * if存在,更新value,调整位置
         * else不存在,插入队尾
         */
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
        } else {
            if (size == capacity) {
                removeLeastRecently();
            }
            addRecently(key, value);
        }
    }

    public Object get(String key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        addLast(node);
        return node.getValue();
    }

    private void deleteKey(String key) {
        Node x = map.get(key);
        // 从链表中删除
        remove(x);
        // 从 map 中删除
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node node = removeFirst();
        map.remove(node.getKey());
    }

    private void addRecently(String key, Object value) {
        Node node = new Node(key, value);
        addLast(node);
        map.put(key, node);
    }

    private Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    private void addLast(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
        node.next = tail;
        size++;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
        size--;
    }

    @Data
    @NoArgsConstructor
    class Node {

        private String key;

        private Object value;

        private Node pre;

        private Node next;

        public Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
